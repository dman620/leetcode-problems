# My Leetcode Submissions

*This is a composition of all the submissions I have made to Leetcode.com with code, thoughts, and what I have learned.  They are organized by problem, not by date*

---

## 2. Add Two Numbers

https://leetcode.com/problems/add-two-numbers/

### My Submission(s): 

https://leetcode.com/submissions/detail/466982081/

### Thoughts:

*3/15/2021*

This one was tricky to start because I hadn't worked with LinkedLists in a long time so I had to spend some time refreshing my knowledge, but once I remembered everything from school it was not hard.  The submission page said that my submission ran faster than 100% of java programs, but if you look at the distribution you can see that it actually only runs faster than about 75%.  It looks like if your program is equal in run time then it just gives you the benefit of the doubt and counts it as faster.  Since mine ran at 1ms (and it only counts whole ms, meaning you can't get faster than that), it says it runs faster than 100% of submissions.

## 3. Longest Substring Without Repeating Characters

https://leetcode.com/problems/longest-substring-without-repeating-characters/

### My Submission(s):

https://leetcode.com/submissions/detail/469571641/

https://leetcode.com/submissions/detail/469880790/

### Thoughts:

*3/18/2021*

The method that I used first is essentially the brute force method.  I 
knew before making this that my approach would have poor time 
complexity, but I figured that O(n<sup>2</sup>) was "good enough".  My 
initial algorithm worked by counting up and comparing the substring of 
the chars that it had passed to the next char.  If the char is in the 
substring, then it resets count to 0 and continues, and keeps track of 
the highest count yet.  However, I realized that it was possible for the 
algorithm to "skip" over possible matches.  This string, for example, 
would cause the longest substring to get skipped "1231456".  It would 
throw out the 123 after it sees that the next 1 is a repeat.  Then it 
would start counting again at 1456 and return 4.  However, that is not 
the longest substring.  "231456" is.  So, to exhaust all possibilities, 
the examiner would have to reset back to the second character of the 
last substring examined.  Once I saw this, I realized that the real time 
complexity is worse that O(n<sup>2</sup>), but I finished the algorithm 
just to see if it would work and qualify (it did, but much slower than 
others).  

*3/19/2021*

The next day, I was going to see if I could get an algorithm running 
that was better than the old one.  I couldn't think of anything, so I 
took a peek at the title to the suggested solutions.  The first one was 
titled Brute Force, and the second one was called sliding window.  I 
remembered learning about the concept of sliding window in school, so 
that was all I needed to make the algorithm.  It works just like how 
you'd imagine.  I think in the worst case this algorithm is still 
O(n<sup>2</sup>), but it clearly runs much faster in the average case.

## 4. Median of Two Sorted Arrays

https://leetcode.com/problems/median-of-two-sorted-arrays/

### My Submission(s):

https://leetcode.com/submissions/detail/471607223/

### Thoughts:

*3/23/2021*

For this problem, I spent significant time in the analysis and design phase.  I used my notebook to draw the problem out and only started coding once I was satisfied with my pseudocode.  I 
realized that if the contents of the parameters were in the same sorted list, then the complexity would be O(1).  So, the entire runtime complexity of my program is used on an efficient 
merge algorithm.  The algorithm will merge the arrays into one, preserving the sort order.  The algorithm is O(n + m) in the worst case.  The problem stated as a challenge that I could try 
to make it O(log(n + m)).  I have no idea how to do that.  The algorithm is stated on the website to be in the top 98<sup>th</sup> percentile (runtime), though, so maybe it is O(log(n + 
m)) for some reason. I'm not really sure how to verify whether this is true.  According to my calculations it should be O(n + m).

I'm not sure why I haven't used methods before this problem.  I assumed that if I tried to include a method, then the code would not compile.  Either way, I believe that some of my other 
submissions could be cleaned up by using methods.

## 7. Reverse Integer

https://leetcode.com/problems/reverse-integer/

### My Submission(s): 

https://leetcode.com/submissions/detail/469036678/

### Thoughts:

*3/17/2021*

After reading the solution page for this problem I was surprised that 
the precondition check could be done in such a simple way.  I might have 
arrived at this myself if I were thinking about this problem as a 
mathmetician.  I was thinking more like a philosopher when I arrived at 
my solution.  The LeetCode solution is simpler because that solution 
just gets on with it and checks at each step whether overflow is 
mathematically happening.  My solution takes great pains to ensure that 
overflow is impossible before doing anything else.  I achieved this by 
comparing each digit with the factor that it would be going into.  i.e. 
for x=8234567891, the 1 at the end would be compared to the 2 from 
Integer.MAX_VALUE = 2147483647.  If the number being compared is less 
than the max value factor, then it passes and overflow is impossible.  
If it is greater, then overflow is guaranteed.  If it is equal then you 
must make this comparison with the next set of digits.  I actually 
really like my solution because it is a cool algoritm.

My solution works, but it is not as readable or elegant as the suggested 
solution.  I should spend more time analyzing the problem from a 
mathmatical point of view in the future.

## 15. Three Sum:

https://leetcode.com/problems/3sum/

### My Submission:

https://leetcode.com/submissions/detail/469119165/

### Thoughts:

*3/18/2021*

When I started this one, I predicted that my submission would be very 
time-inefficient.  Turns out I was correct.  It still works, but it 
takes so long for large lists that it is a problem.  I knew this would 
be the case but I coded it anyways just for fun and to see if I could 
think of a better way to do it later.  I never thought of a better way, 
but I researched the problem and found a neat solution 
https://leetcode.com/problems/3sum/discuss/1113198/Java-solution-O(N2)-with-detailed-explanation

This solution seems like something that I could have thought of myself 
if I had drawn the problem out instead of getting started right away.  That solution is included here and credit is given in the file also.
