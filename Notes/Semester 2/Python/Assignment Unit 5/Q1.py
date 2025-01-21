class MyClass:
  class_variable = "I am a class variable"

  def __init__(self):
      self.instance_variable = "I am an instance variable"

print(MyClass.class_variable)  # Accessing class variable
print(MyClass().instance_variable)  # Accessing instance variable
