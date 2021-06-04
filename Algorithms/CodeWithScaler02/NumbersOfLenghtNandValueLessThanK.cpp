int Solution::solve(vector<int> &A, int B, int C) {
    int l = A.size();
        if(l == 0) 
        { 
            return 0; // When the length of the array is 0 
        } 
        int temp = C,count = 0, ans = 0; 
        
        while(temp)
        {  
            count++; 
            temp /= 10; // Here we are counting how many elements are present in C
        }
        
        // CASE 1 --> 
        if(count<B) 
        { // If the number of elements in C is lesser than that of the numbers we are to find
            return 0; // Since this condition is impossible
        }
        
        // CASE 2 --> WHEN B < C
        else if (count > B )
        { // When the number of elements in C is greater than that of B
            // We first specify the condition for having 0 as the first variable 
            if(A[0]==0) 
            {
                ans = (l-1)*pow(l, B-1);
            } 
            else 
            {
                ans = pow(l, B);
            }
            if(B==1 && A[0] == 0) 
            {
                ans++;
            }
            
        return ans;
        }
        // CASE 3 --> WHEN C == B 
        else  
        {
            if (B==1) 
            {
                for(int i =0; i<l; i++) 
                {
                    if (A[i]<C) 
                    {
                        ans++;    
                    }
                }
            }
            else 
            {
                vector<int> temp(B);
                // We create this new vector in order to store the elements in an individual fashion
                for(int i = B-1; i>=0 ; i--) // We are traversing backwards and dividing to get the elements
                {
                    temp[i] = C%10;
                    C /= 10;
                }
                count = 0;
                for(int i = 0; i<l ; i++) 
                {
                    if (A[i] == 0) 
                    {
                        continue;
                    }
                    if(A[i]>temp[0]) 
                    {
                        break;
                    }
                    count++;
                }
                ans += (count)*(pow(l, B-1));
            int flag = 0; 
            int j=0;
            
            for(int i = 0; i<l ; i++)
            {
                if(A[i]==temp[j]) { flag = 1; }
                
            }
            j++;
            while( flag == 1 && j<=B-1) 
            {
                flag = 0;
                int countx = 0;
                for(int i=0; i<l ; i++)
                {
                    if(A[i]>temp[j])
                    {
                        countx++;
                    }
                    if(A[i] == temp[j])
                    {
                        flag = 1;
                    }
                }
                ans -= ((countx)*(pow(l,B-j-1)));
                j++;
                
            }
            if(j==B && flag == 1) {ans--;}
            }
        }
        return ans;
}

