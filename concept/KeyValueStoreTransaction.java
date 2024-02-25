import java.util.*;

public class KeyValueStoreTransaction {
	private Stack<Map<String, Integer>> stack;
	public KeyValueStoreTransaction() {
		this.stack = new Stack<Map<String, Integer>>();
		this.stack.push(new HashMap<String, Integer>());
	}
	
	public void set(String key, int value) {
		this.stack.peek().put(key, value);
	}
	
	public int get(String key) {
		for (int i = stack.size() - 1; i >= 0; --i) {
			if (this.stack.get(i).containsKey(key)) return this.stack.get(i).get(key);
		}
		return -1;
	}
	
	public void begin() {
		this.stack.push(new HashMap<String, Integer>());
	}
	
	public void commit() {
		Map<String, Integer> p = this.stack.pop();
		for (Map.Entry<String, Integer> entry : p.entrySet()) {
			this.stack.peek().put(entry.getKey(), entry.getValue());
		}
	}
	
	public void rollback() {
		this.stack.pop();
	}
	
	public static void main(String[] args) {		
		KeyValueStoreTransaction kvst = new KeyValueStoreTransaction();
		kvst.set("a", 1);
		System.out.println(kvst.get("a") == 1);
		System.out.println(kvst.get("b") == -1);
		
		kvst.begin();
		kvst.set("b", 2);
		System.out.println(kvst.get("a") == 1);
		System.out.println(kvst.get("b") == 2);
		kvst.begin();
		kvst.set("c", 3);
		System.out.println(kvst.get("a") == 1);
		System.out.println(kvst.get("b") == 2);
		System.out.println(kvst.get("c") == 3);
		kvst.commit();
		System.out.println(kvst.get("a") == 1);
		System.out.println(kvst.get("b") == 2);
		System.out.println(kvst.get("c") == 3);
		kvst.rollback();

		System.out.println(kvst.get("a") == 1);
		System.out.println(kvst.get("b") == -1);
		System.out.println(kvst.get("c") == -1);
	}

}
