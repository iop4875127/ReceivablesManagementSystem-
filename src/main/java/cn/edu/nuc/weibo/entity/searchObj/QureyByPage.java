package cn.edu.nuc.weibo.entity.searchObj;

public class QureyByPage {

	 private int startNumber;
	 
	 private int endNumber;
	 

	 
	 public int getStartNumber() {
			return startNumber;
		}

		public void setStartNumber(int startNumber) {
			this.startNumber = startNumber;
		}

		public int getEndNumber() {
			return endNumber;
		}
		

		public void setEndNumber(int endNumber) {
			this.endNumber = endNumber;
		}

		@Override
		public String toString() {
			return "QureyByPage [startNumber=" + startNumber + ", endNumber=" + endNumber + "]";
		}

}
