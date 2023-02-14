public class projec {
  public static int func(int[] nums) {
    return func(nums, 0, 1);
  }

  private static int func(int[] nums, int index, int result) {
    if (index == nums.length) {
      return result;
    }
    return func(nums, index + 1, result * nums[index]);
}

  public static void main(String[] args) {
    int[] someNums = {2, 3, 5, 7};
    System.out.println(func(someNums));
  }
}
