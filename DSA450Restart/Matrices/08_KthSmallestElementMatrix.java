package DSA450Restart.Matrices;
import java.util.*;


class Solution
{
    /*
    Don't feel like much of a talker today so I'll just type what I understand here

    Our matrix is row-column wise sorted
    How were we supposed to take advantage of that again? Binary Search ain't it? 
    Even if we do binary search we need the kth smallest element from this matrix

    One way to do this is ofc the previous method where we put all elements in the 
    matrix into a 1D array and then use either the Quick Select algorithm or the
    priority queue method to find the kth element

    So yeah that's one approach, what can be other approaches? 

    Looks like a space of N is expected from us and not one of N*N
    Well I get that the heap is gonna give us a TC of K*LogN but what about the space it takes? 
    The heap will ofc take the N*N amount of space as well won't it? 

    */


}