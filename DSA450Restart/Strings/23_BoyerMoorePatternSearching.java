package DSA450Restart.Strings;

class Solution_BoyerMoore
{
    /*
    This will probably just be a note for understanding
    the algorithm. 

    As usual we have the standard example for string pattern matching
    Input:  txt[] = "THIS IS A TEST TEXT"
        pat[] = "TEST"
    This involves string preprocessing like we do in KMP

    We have a bad match table now what is that? 
    This algorithm works with the idea of bad match rule and a good shift rule

    Good shift rule -> Using the values of the characters in the bad match table, we keep
                        on shifting the patern 
    There should not be any repeated characters in our bad match table

    Our bad match table will have all the unique chracters in our pattern
    and in place of any repeated character we place * -> length of pattern in this
    case we have length of pattern as 4 so we set the value of last repeated T as 4
    
    In the pattern the value of the last character is T and it's value is 4
    so we set the value of our last T as 4 as well 
    T E S *
    4     4
    
    Now we calculate the rest of the values, when calculating them we follow
    a formula, 
    value = length - index - 1 => T = 4 - 0 - 1 = 3 but we have repeated so 4
    => E = 4 - 1 - 1 = 2
    => S = 4 - 2 - 1 = 1
    => T = 4 - 3 - 1 = 0 => But repeated so we take lenght => 4
    T E S *
    4 2 1 4

    First we consider the first 4 characters 
    THIS IS A TEST TEXT
    We match the characters from right to left
    Step1: 
    TEST
    THIS IS A TEST TEXT
    
    Here we see that there is a mismatch betweent he last character of our TEST and that of
    the 4th character of our string
    So whenever we find this, what we do is, we move our pattern's from the current position
    to the size()th index if that mismatched character is not in our bad match table
    Meaning since, our last elemnet is not matching anyway, we have no point in searching for the others
    Like we consider the * value if our mismatched character is not in our bad match table

    But if we find a mismatch and our mismatched character is in the bad match table, in that case we
    move our pattern from the -> current_pos(pattern) + bad_match_table(mismatched_characters) 
    */
}
