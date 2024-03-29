package design;

/*
 http://thought-works.blogspot.com/2012/11/object-oriented-design-for-elevator-in.html
 http://blog.csdn.net/raycode/article/details/3975944
 */
public class TestGoodElevator {
	public static void main(String args[]) {
		GoodElevator e2 = new GoodElevator();
		e2.openDoor();
		e2.closeDoor();
		e2.goUp();
		e2.goUp();
		e2.goDown();
		System.out.println("电梯在第" + e2.getFloor() + "层");
		e2.openDoor();
		e2.closeDoor();
		e2.goDown();
		e2.openDoor();
		e2.closeDoor();
		e2.goDown();
		e2.goDown();
		if (e2.getFloor() != 5 && !e2.isOpen())
			e2.setFloor(5);
		e2.openDoor();
		e2.closeDoor();
		e2.setFloor(10);
		System.out.println("-------电梯测试结束-------");
	}
}

class GoodElevator {
	private boolean doorOpen = false;
	private int floor = 1;
	private int weight = 0;
	final int CAPACITY = 1000;
	final int TOP_FLOOR = 5;
	final int BOTTOM_FLOOR = 1;

	public void openDoor() {
		doorOpen = true;
	}

	public void closeDoor() {
		checkWeightSensors();
		if (weight <= CAPACITY)
			doorOpen = false;
		else
			System.out.println("超重，门不能关！");
	}

	private void checkWeightSensors() {
		weight = (int) (Math.random() * 1500);
		System.out.println("当前乘客总重量是:" + weight + "公斤");
	}

	public void goUp() {
		if (!doorOpen) {
			if (floor < TOP_FLOOR) {
				floor++;
				System.out.println("电梯已上到第" + floor + "层");
			} else
				System.out.println("电梯已在顶层，不能再上升");
		} else
			System.out.println("电梯门未关，不能上升！");
	}

	public void goDown() {
		if (!doorOpen) {
			if (floor > BOTTOM_FLOOR) {
				floor--;
				System.out.println("电梯已下到第" + floor + "层");
			} else
				System.out.println("电梯已在最底层，不能再下降");
		} else
			System.out.println("电梯门未关，不能下降！");
	}

	public void setFloor(int goal) {
		if (goal >= BOTTOM_FLOOR && goal <= TOP_FLOOR) {
			while (floor != goal) {
				if (floor < goal)
					goUp();
				else
					goDown();
			}
			System.out.println("电梯按要求停在第" + goal + "层");
		} else
			System.out.println("没有第" + goal + "层");
	}

	public int getFloor() {
		return floor;
	}

	public boolean isOpen() {
		return doorOpen;
	}
}