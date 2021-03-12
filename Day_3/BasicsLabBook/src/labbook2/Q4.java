package labbook2;

public class Q4 {
		
		public static void main(String[] args) {
			Q4 obj1 = new Q4();
			Stack obj = new Stack(5);
			obj.insert(123);
			obj.insert(56);
			obj.insert(34);
			obj.display();
			obj.remove();
			obj.remove();
			obj.display();
		}
		
		public class Stack {
			
			private int arr[];
			private int top;
			private int len;
			
			Stack(int limit){
				this.arr = new int[limit];
				this.top = -1;
				this.len = limit;
			}
			
			public int insert(int num) {
				if(!isFull()) {	
					top++;
					this.arr[top] = num;
					return 1;
				}
				return 0;
			}
			
			public int remove() {
				if(!isEmpty()) {			
					int num = arr[top];
					top--;
					return num;
				}
				return -1;
			}
			
			public int length() {
				return top + 1;
			}
			public Boolean isEmpty() {
			    return top == -1;
			}

			public Boolean isFull() {
			    return top == len - 1;
			}
			
			public void display() {
				for(int i = 0; i <= this.top; i++) {
					System.out.println(this.arr[i]);
				}
			}
			
		}

}
