//Double Pointer, O(N^2)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
		int len = nums.length;
		if(nums == null || len < 3)	return ans;

		Arrays.sort(nums);

		for (int i = 0; i < len; i++){
			if (nums[i] > 0)	break;
			if (i > 0 && nums[i] == nums[i - 1])	continue; //No Repeat
			int L = i + 1;
			int R = len - 1;

			while(L < R){
				int sum = nums[i] + nums[L] + nums[R];
				if (sum == 0){
					ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
					while (L < R && nums[L] == nums[L + 1])	L++; //No Repeat
					while (L < R && nums[R] == nums[R - 1])	R--; //No Repeat
					L++;
					R--;
				}
				else if (sum < 0)	L++;
				else if (sum > 0)	R--;
			}
		}
		return ans;
    }
}