class ConditionalIntegerSum{
  static int startingValue = 10;
  static int endValue = 950;
  static int[] dividend = { 6, 9};

  public static boolean Divisible(int num) {
  for (int i : dividend) {
    if (num % i == 0) {
      return true;
    }
  }
  return false;
}

  public static void main (String[] args){
    int total = 0;
    for (int i = startingValue; i <= endValue ; i++ ) {
      if (Divisible(i)) total += i;
    }
    System.out.print("Total Is: ");
    System.out.println(total);
  }
}
