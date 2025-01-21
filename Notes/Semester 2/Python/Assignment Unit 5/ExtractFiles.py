
import csv

def read_csv_until_expression(file_path, expression):
    try:
        with open(file_path, 'r', newline='') as file:
            reader = csv.reader(file, delimiter=';')
            for row in reader:
                if expression in row:
                    break  # Stop reading when the expression is found
                print(row)  # Print the row
    except FileNotFoundError:
        print(f"File '{file_path}' not found.")
    except Exception as e:
        print(f"An error occurred: {e}")

file_path = 'Unit5AssignmentQuestions0.txt'  # Path to your text file
expression = ';'  # Expression to stop reading at
import csv
import os

def read_csv_and_write_to_separate_files(file_path, output_directory):
    try:
        # Create the output directory if it doesn't exist
        os.makedirs(output_directory, exist_ok=True)

        with open(file_path, 'r', newline='') as file:
            reader = csv.reader(file, delimiter=';')
            for i in reader:
                # Create a separate file for each entry
                output_file_path = os.path.join(output_directory, f'entry_{i}.csv')
                print(reader)
                # with open(output_file_path, 'w', newline='') as output_file:
                #     writer = csv.writer(output_file, delimiter=';')
                #     writer.writerow(row)  # Write the row to the output file
    except FileNotFoundError:
        print(f"File '{file_path}' not found.")
    except Exception as e:
        print(f"An error occurred: {e}")
output_directory = 'output_files'
#   # Directory to store the output files
# read_csv_and_write_to_separate_files(file_path, output_directory)
# Open the CSV file for reading
with open(file_path, 'r', newline='') as file:
    # Create a CSV reader object
    reader = csv.reader(file, delimiter=";")
    # Iterate over each row in the CSV file
    for row in reader:
        # Print each row
        print(row)
