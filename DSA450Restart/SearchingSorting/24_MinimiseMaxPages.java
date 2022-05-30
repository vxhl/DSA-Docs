class MinimisePages
{
    //Your code here
        // Ok so if we want the maximum numbe of pages to be minimised, first let us find the range of the maximum number of pages right
        // 12 34 67 90 -> we have 2 students to distribute 
        // If in case that we had more students and less books then we just retunr -1 
        
        // 12  191
        // 46 157    => 191 157 113
        // 113 90
        
        
        // 10 20 30 40
        // The number of pages should be the maximum paged book which is 90 
        // because in case we had 40 10 10 10-> 2 
        // Then 40 | 30 -> 40
        // The max range for the books would be ofc the total no. of pages
        // 100 pages
        // -> 40 -> 100 <-
        // 100+40/2 => 70 as the maximum limit for each student to have a book
        // basically we set 70 as a possible answer and we try to see if it is possible
        // s1 -> 10 + 20 + 30 -> 60
        // =====> res = 70 -> As the max for each student
        // s2 -> 40 
        
        // 40 + 70 / 2 => 55
        // 55 as the max possible 
        // 55 + 70 / 2 => 62 as the max possible
        // s1 -> 10 + 20 + 30
        // s2 -> 40
        // res = Math.min(res, mid) => 70 -> 62
        // 55 -> 62
        // 55+62/2 -> 58
        // 55->58
        // s1 -> 10+20+30XXX
        // s2 -> 30+40XXX
        // so we find 58 as not valid right
        // 58 -> 62
        // 58+62/2 -> 60
        // s1 -> 10 + 20 + 30 -> 60
        // s2 -> 40 
        // We have found 60
        // 58 and 60
        // 58+60/2 -> 59 
        // 59
        // find it as non valid
        // 59+60 -> we will be reaching the condition
        private static boolean isValid(int[] A, int N, int mid, int M)
        {
            int sum = 0;
            int students= 1;
            for(int i=0; i<N; i++)
            {
                if(mid<A[i]) return false;
                if(sum+A[i]>mid)
                {
                    students++;
                    sum = A[i];
                    
                }
                else
                {
                    sum+=A[i];
                }
            }
            return students>M ? false: true;
            
            
        }
        //Function to find minimum number of pages.
        public static int findPages(int[]A,int N,int M)
        {
            // Edge cases
            if(A.length<M)
            {
                return -1;
            }
            
            
            int end = 0;
            for(int i: A)
            {
                end+=i;
                
            }
            int start = 0;
            for(int i: A)
            {
                if(i>start)
                {
                    start = i;
                }
            }
            
            // System.out.print(start+" "+end);
            // If we cannot distribute we return -1
            int res = -1;
            int mid = start+(end-start)/2;
            while(start<=end)
            {
        
                
                if(isValid(A, N, mid, M))
                {
                    // System.out.print("resets");
                    res = mid;
                    end = mid-1;
                }
                else
                {
                    start = mid+1;
                }
                mid = start+(end-start)/2;
            }
            
            
            return res;
        }
}
