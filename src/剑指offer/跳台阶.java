package 剑指offer;

public class 跳台阶 {
    public int JumpFloor(int target) {
        if (target <= 1) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
