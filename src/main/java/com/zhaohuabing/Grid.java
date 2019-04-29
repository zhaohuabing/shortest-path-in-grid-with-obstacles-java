package com.zhaohuabing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {
  // There are three kinds of nodes in the grid:
  // 1 normal node
  // 0 obstacle
  // 9 source and destination, only two nodes in the array should be equals 9
  private int[][] nodes;

  public Grid(int[][] nodes) {
    this.nodes = nodes;
  }

  public List<Node> shortestPath() {
    // key node, value parent
    Map<Node, Node> parents = new HashMap<Node, Node>();
    Node start = null;
    Node end = null;

    // find the start node
    for (int row = 0; row < nodes.length; row++) {
      for (int column = 0; column < nodes[row].length; column++) {
        if (nodes[row][column] == 9) {
          start = new Node(row, column, nodes[row][column]);
          break;
        }
      }
      if (start != null) {
        break;
      }
    }

    if (start == null) {
      throw new RuntimeException("can't find start node");
    }

    // traverse every node using breadth first search until reaching the destination
    List<Node> temp = new ArrayList<Node>();
    temp.add(start);
    parents.put(start, null);

    boolean reachDestination = false;
    while (temp.size() > 0 && !reachDestination) {
      Node currentNode = temp.remove(0);
      List<Node> children = getChildren(currentNode);
      for (Node child : children) {
        // Node can only be visted once
        if (!parents.containsKey(child)) {
          parents.put(child, currentNode);

          int value = child.getValue();
          if (value == 1) {
            temp.add(child);
          } else if (value == 9) {
            temp.add(child);
            reachDestination = true;
            end = child;
            break;
          }
        }
      }
    }

    if (end == null) {
      throw new RuntimeException("can't find end node");
    }

    // get the shortest path
    Node node = end;
    List<Node> path = new ArrayList<Node>();
    while (node != null) {
      path.add(0, node);
      node = parents.get(node);
    }
    printPath(path);
    return path;
  }

  private List<Node> getChildren(Node parent) {
    List<Node> children = new ArrayList<Node>();
    int x = parent.getX();
    int y = parent.getY();
    if (x - 1 >= 0) {
      Node child = new Node(x - 1, y, nodes[x - 1][y]);
      children.add(child);
    }
    if (y - 1 >= 0) {
      Node child = new Node(x, y - 1, nodes[x][y - 1]);
      children.add(child);
    }
    if (x + 1 < nodes.length) {
      Node child = new Node(x + 1, y, nodes[x + 1][y]);
      children.add(child);
    }
    if (y + 1 < nodes[0].length) {
      Node child = new Node(x, y + 1, nodes[x][y + 1]);
      children.add(child);
    }
    return children;
  }

  private void printPath(List<Node> path) {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";

    for (int row = 0; row < nodes.length; row++) {
      for (int column = 0; column < nodes[row].length; column++) {
        String value = nodes[row][column] + "";

        // mark path with red X
        for (int i = 1; i < path.size() - 1; i++) {
          Node node = path.get(i);
          if (node.getX() == row && node.getY() == column) {
            value = ANSI_RED + "X" + ANSI_RESET;
            break;
          }
        }
        if (column == nodes[row].length - 1) {
          System.out.println(value);
        } else {
          System.out.print(value + ".....");
        }
      }

      if (row < nodes.length - 1) {
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < nodes[row].length - 1; j++) {
            System.out.print(".     ");
          }
          System.out.println(".     ");
        }
      }
    }
    System.out.println();
    System.out.println("Path: "+ path);
  }
}

class Node {
  private int x;
  private int y;
  private int value;

  public Node(int x, int y, int value) {
    this.x = x;
    this.y = y;
    this.value = value;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "(x: " + x + " y: " + y + ")";
  }

  @Override
  public int hashCode() {
    return x * y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (this.getClass() != o.getClass()) return false;
    Node node = (Node) o;
    return x == node.x && y == node.y;
  }
}
