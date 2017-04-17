import java.util.HashMap;

public class ZombieCluster {
	static int[][] zArray = null;
	static int len;
	static HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

	static void dfs(int u) {
		for (int j = 0; j < len; j++) {
			if (zArray[u][j] > 0 && j != u && (Boolean) visited.get(j) == false) {
				visited.put(j, true); 
				dfs(j);  
			}
		}
	}

	static int zombieCluster(String[] zombies) {
		zArray = new int[zombies.length][zombies.length];
		len = zombies.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				char arr[] = zombies[i].toCharArray();
				zArray[i][j] = arr[j] - '0';
			}
			visited.put(i, false);
		}
		int result = 0;
		for (int u = 0; u < len; u++) { // 0
			if ((Boolean) visited.get(u) == false) {
				visited.put(u, true); 
				result++;
				dfs(u);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// find number of cluster from given zombie matrix
		
		String ip1[] = new String []{"1000", "0100", "0010", "0001"}; // result 4 as all zombie will be in seperate cluster
		System.out.println(zombieCluster(ip1)); 
		
		String ip2[] = new String[]{"1100", "1110", "0110", "0001"}; // result 2 as (1,2), (2,3) will create one cluster- {1,2,3} and {4} in another cluster 
		System.out.println(zombieCluster(ip2));
	}

}
