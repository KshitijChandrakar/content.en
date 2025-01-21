from movenet import *
import pickle

## Load the input image
# image_path = 'input_image.jpeg'
# image_path = r"Movenet_Tensorflow\input_image.jpeg"  # Replace with your image path
# image1 = tf.io.read_file(image_path)
# image1 = tf.image.decode_jpeg(image1)
def Outliers(data, threshold=3):
    """
    Detect outliers in the given data using z-score method.

    Parameters:
    data (array-like): The input data.
    threshold (float): The threshold value for the z-score. Default is 3.

    Returns:
    list: A list containing the indices of the outliers in the input data.
    """
    outliers = []
    mean = np.mean(data)
    std = np.std(data)

    for i, value in enumerate(data):
        z_score = (value - mean) / std
        if np.abs(z_score) > threshold:
            outliers.append(i)

    return True if outliers != [] else False

# input_image = tf.expand_dims(image, axis=0)
# input_image = tf.image.resize_with_pad(input_image, input_size, input_size)

# # Run model inference.
# keypoints = movenet1(input_image)
# # Visualize the predictions with image.
# display_image = tf.expand_dims(image, axis=0)
# display_image = tf.cast(tf.image.resize_with_pad(
#     display_image, 1280, 1280), dtype=tf.int32)
# output_overlay = draw_prediction_on_image(
#     np.squeeze(display_image.numpy(), axis=0), keypoints)
xavg, yavg, xstd, ystd, threshold = 0,0,0,0,3.3
xlist,ylist,xslist,yslist = [1] * 20, [1] * 20, [1] * 20, [1] * 20
def jump():
    print("JUMPING!")
# Open a connection to the camera (webcam)
cap = cv2.VideoCapture(0)

# Check if the camera opened successfully
if not cap.isOpened():
    print("Error: Could not open camera.")
    exit()
FirstRun = 0
# Loop to continuously capture frames from the camera and display them
while True:
    # Capture frame-by-frame
    ret, frame = cap.read()

    # Check if the frame was captured successfully
    if not ret:
        print("Error: Could not capture frame.")
        break
    image = frame
    # Display the frame in the window
    # cv2.imshow("Camera Output", frame)
    input_image = tf.expand_dims(image, axis=0)
    input_image = tf.image.resize_with_pad(input_image, input_size, input_size)
    if FirstRun == 0:
        image_height, image_width = frame.shape[:2]
        crop_region = init_crop_region(image_height, image_width)

    # Run model inference.
    # keypoints = movenet1(input_image)

    keypoints = run_inference(
      movenet1, frame, crop_region,
      crop_size=[input_size, input_size])
    crop_region = determine_crop_region(keypoints, image_height, image_width)
    # keypoint_locs,edges,edgeColors = keypoints_and_edges_for_display(keypoints, input_size, input_size)

    # Get Keypoint coords, edges, and edge colors and average it
    (keypoints_locs, edges_xy, edge_colors) = keypoints_and_edges_for_display(keypoints, image_width, image_height)
    cxavg, cyavg= np.mean(keypoints_locs, axis =0)
    cxstd, cystd= np.std(keypoints_locs, axis =0)
    xlist = xlist[1:] + [cxavg,]
    ylist = ylist[1:] + [cyavg,]
    xslist = xslist[1:] + [cxstd,]
    yslist = yslist[1:] + [cystd,]
    if Outliers(xlist, threshold = threshold) or Outliers(ylist, threshold = threshold):
        jump()

    # Visualize the predictions with image.
    display_image = tf.expand_dims(image, axis=0)
    display_image = tf.cast(tf.image.resize_with_pad(
        display_image, 1280, 1280), dtype=tf.int32)
    output_overlay = draw_prediction_on_image(
        np.squeeze(display_image.numpy(), axis=0), keypoints, close_figure=True)
    tf.cast(tf.image.resize_with_pad(
        output_overlay, 720, 480), dtype=tf.int32)
    FirstRun = 1
    cv2.imshow("Output", output_overlay)
    # Check for key press to exit
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Release the camera and close any open windows
cap.release()
cv2.destroyAllWindows()

# plt.figure(figsize=(5, 5))
# plt.axis('off')
# plt.show()
