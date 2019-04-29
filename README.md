# shortest-path-in-a-grid-with-obstacles-java
Find the shortest path between two points in a unweighted grid with obstacles

Based on breadth first searchalgorithm 

test case

* 9 marks the two points between which we need to find the path 
* 0 marks the obstacles which the path can't go through 
* 1 marks the noraml points which the path can go through
* the length between any two adjacent points is 1

```
      9'''''|'''''|'''''|''''':'''''|'''''|'''''`.
      |     |     |     |     |     |     |      |
      |     |     |     |     |     |     |      |
      |'''''0'''''|'''''|'''''|'''''0'''''|'''''''
      |     |     |     |     |     |     |      |
      |     |     |     |     |     |     |      |
      |.....|.....|.....0.....|.....|.....|......|
      |     |     |     |     |     |     |      |
      |     |     |     |     |     |     |      |
      0-----+-----0-----+-----0-----+-----+------|
      |     |     |     |     |     |     |      |
      |     |     |     |     |     |     |      |
      |'''''|'''''|'''''|'''''|'''''9'''''|''''''|
      |     |     |     |     |     |     |      |
      '     |     |     |     |     |     |      |
      `-----------0-----'-----'-----'-----'------'

```

The above graph can be represented by a two-dimensional array like this:

```
      9 1 1 1 1 1 1 1
      1 0 1 1 1 0 1 1 
      1 1 1 0 1 1 1 1
      0 1 0 1 0 1 1 1
      1 1 1 1 1 9 1 1
      1 1 0 1 1 1 1 1
```

There are two shortest paths between these two points, one is marked with *, the other is marked with #. 

```
      9 # # # # 1 1 1
      * 0 1 1 # 0 1 1 
      * * 1 0 # # 1 1
      0 * 0 1 0 # 1 1
      1 * * * * 9 1 1
      1 1 0 1 1 1 1 1
```
