class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val list = mutableListOf<List<Int>>()
        for(index in 0..(nums.size-2)){
            var target = nums[index]
            var L = index+1
            var R = nums.size-1
            while(L<R){
                var sum = target+nums[L]+nums[R]
                when {
                    sum>0 -> R--
                    sum<0 -> L++
                    else ->  {
                        val value = listOf(target,nums[L],nums[R])
                        if(!list.contains(value)) list.add(value)
                        L++
                        R--
                    }
                }
            }
        }
        return list
    }
}
