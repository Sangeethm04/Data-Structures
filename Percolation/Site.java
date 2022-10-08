public class Site {

  private int row;
  private int col;
  private boolean full;
  private boolean open;
  private boolean connectedToOpenBottom;
  private boolean getConnectedToOpenTop;


  public Site(int row, int col) {
      this.row = row - 1;
      this.col = col - 1;
      this.open = false;
  }
  public int getRow() {
      return row;
  }
  public int getCol() {
      return col;
  }
  public void setOpen(boolean open) {
      this.open = true;
  }
  public boolean getOpen() {
      return this.open;
  }
  public void setfull(boolean full) {
      this.full = full;
  }
  public boolean getfull() {
      return this.full;
  }
  public void setConnectedToOpenBottom(boolean connectedToBottom) {
      this.connectedToOpenBottom = connectedToBottom;
  }
  public boolean getConnectedToOpenBottom() {
      return this.connectedToOpenBottom;
  }
  public void setConnectedToOpenTop(boolean connectedToTop) {
      this.getConnectedToOpenTop = connectedToTop;
  }
  public boolean getConnectedToOpenTop() {
      return this.getConnectedToOpenTop;
  }
}