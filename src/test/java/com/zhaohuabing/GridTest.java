package com.zhaohuabing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class GridTest {

  @Test
  public void testShortestPathInUnweightedGrid1() {
    Grid grid = this.constructGrid1();
    List<Node> path = grid.shortestPath();
    assertEquals(path.size(), 10);
  }

  @Test
  public void testShortestPathInUnweightedGrid2() {
    Grid grid = this.constructGrid2();
    List<Node> path = grid.shortestPath();
  }

  @Test
  public void testNode() {
    Node node1 = new Node(0, 0, 0);
    Node node2 = new Node(0, 0, 0);
    Node node3 = new Node(0, 1, 0);

    assertEquals(node1, node2);
    assertNotEquals(node1, node3);

    Map<Node, Node> testMap = new HashMap<Node, Node>();
    testMap.put(node1, null);
    testMap.put(node3, null);
    testMap.put(node3, node2);

    assertEquals(testMap.get(node1), null);
    assertEquals(testMap.get(node3), node1);
    assertEquals(testMap.size(), 2);
  }

  /** Create a grid for testing
   *
   *   9'''''|'''''|'''''|''''':'''''|'''''|'''''`.
   *   |     |     |     |     |     |     |      |
   *   |     |     |     |     |     |     |      |
   *   |'''''0'''''|'''''|'''''|'''''0'''''|'''''''
   *   |     |     |     |     |     |     |      |
   *   |     |     |     |     |     |     |      |
   *   |.....|.....|.....0.....|.....|.....|......|
   *   |     |     |     |     |     |     |      |
   *   |     |     |     |     |     |     |      |
   *   0-----+-----0-----+-----0-----+-----+------|
   *   |     |     |     |     |     |     |      |
   *   |     |     |     |     |     |     |      |
   *   |'''''|'''''|'''''|'''''|'''''9'''''|''''''|
   *   |     |     |     |     |     |     |      |
   *   '     |     |     |     |     |     |      |
   *   `-----------0-----'-----'-----'-----'------'
   *
   */
  private Grid constructGrid1() {
    int[][] nodes = new int[6][8];
    for (int row = 0; row < 6; row++) {
      for (int column = 0; column < 8; column++) {
        nodes[row][column] = 1;
      }
    }
    // source and destination
    nodes[0][0] = 9;
    nodes[4][5] = 9;

    // obstacles
    nodes[1][1] = 0;
    nodes[1][5] = 0;
    nodes[2][3] = 0;
    nodes[3][0] = 0;
    nodes[3][2] = 0;
    nodes[3][4] = 0;
    nodes[5][2] = 0;

    return new Grid(nodes);
  }

  /** Create a grid for testing
   *
   *   9'''''|'''''|'''''|''''':'''''|'''''|'''''`0
   *   |     |     |     |     |     |     |      |
   *   |     |     |     |     |     |     |      |
   *   |'''''0'''''|'''''|'''''|'''''0'''''|'''''''
   *   |     |     |     |     |     |     |      |
   *   |     |     |     |     |     |     |      |
   *   |.....|.....|.....0.....|.....|.....0......|
   *   |     |     |     |     |     |     |      |
   *   |     |     |     |     |     |     |      |
   *   0-----+-----0-----+-----0-----+-----9------|
   *   |     |     |     |     |     |     |      |
   *   |     |     |     |     |     |     |      |
   *   |'''''|'''''|'''''|'''''|'''''+'''''|''''''|
   *   |     |     |     |     |     |     |      |
   *   '     |     |     |     |     |     |      |
   *   `-----------0-----'-----'-----'-----'------'
   *
   */
  private Grid constructGrid2() {
    int[][] nodes = new int[6][8];
    for (int row = 0; row < 6; row++) {
      for (int column = 0; column < 8; column++) {
        nodes[row][column] = 1;
      }
    }
    // source and destination
    nodes[0][0] = 9;
    nodes[3][6] = 9;

    // obstacles
    nodes[0][7] = 0;
    nodes[1][1] = 0;
    nodes[1][5] = 0;
    nodes[2][3] = 0;
    nodes[3][0] = 0;
    nodes[3][2] = 0;
    nodes[3][4] = 0;
    nodes[5][2] = 0;

    return new Grid(nodes);
  }
}
