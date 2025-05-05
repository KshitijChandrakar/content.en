class abc {
  private int pri = 10;
  public int getPrivate(){
    return pri;
  }
}
class test extends abc{
  @Override
  public void main(String[] args) {
    int x = getPrivate();
    System.out.println(x);
  }
}
