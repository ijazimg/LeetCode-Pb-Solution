package algorithms;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	//Given an array of integers nums and an integer target,
	//return indices of the two numbers such that they add up to target.
	
	/**
	 * Soultion using brute force
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] soultion1(int[] nums, int target){
		
		for(int i = 0; i < nums.length; i++){
			for(int j = i+1; j< nums.length; j++){
				int difference = target - nums[i];
				
				if(nums[j] == difference){
					return new int[] {i, j};
				}
			}
		}
		throw new IllegalArgumentException("no match found");
	}
	
	/**
	 * Using Hashmap
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] soultion2(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<nums.length; i++){
			int difference = target - nums[i];
			if(map.containsKey(difference)){
				return new int[] {map.get(difference) , i};
			}
			else{
				map.put(nums[i], i);
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		//Input 1: 
		int[] nums =  {2,7,11,15}; int target = 9;
		System.out.println("Sol 1: " + Arrays.toString(soultion1(nums, target)));
		System.out.println("Sol 2: " + Arrays.toString(soultion2(nums, target)));
		//Input 2:
		int[] nums2 = {3,3}; int target2 = 6;
		System.out.println(Arrays.toString(soultion1(nums2, target2)));
		
		
	}

}
