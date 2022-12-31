
// File Header
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Chugimon.java
// Course:   CS 300 Fall 2022
//
// Author:   Aaryaman Singh
// Email:    singh283@wisc.edu
// Lecturer: Mouna Kacem
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Vardaan Kapoor
// Partner Email:   vkapoor5@wisc.edu
// Partner Lecturer's Name: Hobbes
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   __X_ Write-up states that pair programming is allowed for this assignment.
//   _X__ We have both read and understand the course Pair Programming Policy.
//   __X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         N/A
// Online Sources:  N/A
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the Chugimon
 * and ChugiTree classes.
 *
 * @author - Aaryaman Singh and Vardaan Kapoor
 *
 */

public class ChugidexTester {


  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Chugimon class.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testChugimonCompareToEquals()
  {
    Chugimon ch1 = new Chugimon(1, 130);// Mewdos
    Chugimon ch2 = new Chugimon(1, 145);
    Chugimon ch3 = new Chugimon(151, 140);// Mewto
    Chugimon ch4 = new Chugimon(150, 132);
    // scenario 1:one is less than other-fail in 3rd case
    {

      if (ch1.compareTo(ch2) >= 0) {
        return false;
      }
    }

    // scenario 2:one<other-fail in 2nd case
    {
      if (ch4.compareTo(ch3) >= 0) {
        return false;
      }
    }

    // scenario 3:one<other-fail in 1st case
    {
      if (ch1.compareTo(ch3) >= 0) {
        return false;
      }
    }

    // scenario 4:one>other-fail in 3rd case
    {

      if (ch2.compareTo(ch1) <= 0) {
        return false;
      }
    }

    // scenario 5:one>other-fail in 5th case
    {
      if (ch3.compareTo(ch4) <= 0) {
        return false;
      }
    }

    // scenario 6:one>other-fail in 6th case
    {
      if (ch4.compareTo(ch2) <= 0) {
        return false;
      }
    }

    // scenario 7:one=other
    if (ch1.compareTo(new Chugimon(1, 130)) != 0) {
      return false;
    }

    // TODO complete the implementation of this method
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of Chugimon.toString() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testChugimonToString()
  {
    Chugimon ch1 = new Chugimon(1, 130);
    return ch1.toString().equals("Bulbdos#1.130");
  }

  /**
   * Checks the correctness of the implementation of ChugiTree.isValidBSTHelper() method. This
   * tester should consider at least three scenarios. (1) An empty tree whose root is null should be
   * a valid BST. (2) Consider a valid BST whose height is at least 3. Create the tree using the
   * constructors of the BSTNode and its setters methods, (3) Consider a NON-valid BST where the
   * search order property is violated at at least one internal node.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIsValidBSTHelper()
  {
    Chugimon r1 = new Chugimon(1, 6);
    Chugimon r2 = new Chugimon(1, 4);
    Chugimon r3 = new Chugimon(1, 5);
    Chugimon r4 = new Chugimon(1, 7);
    Chugimon r5 = new Chugimon(1, 9);
    Chugimon r6 = new Chugimon(1, 8);
    Chugimon r7 = new Chugimon(1, 3);
    Chugimon r8 = new Chugimon(1, 2);
    Chugimon r9 = new Chugimon(1, 120);

    // scenario 1:non-symmetric tree(bst)
    {
      // setting the tree

      BSTNode<Chugimon> tree1 = new BSTNode<>(r1);
      BSTNode<Chugimon> tree2 = new BSTNode<>(r3);
      BSTNode<Chugimon> tree3 = new BSTNode<>(r2, tree1, tree2);
      BSTNode<Chugimon> tree4 = new BSTNode<>(r4, tree3, null);
      BSTNode<Chugimon> tree5 = new BSTNode<>(r9);
      BSTNode<Chugimon> tree6 = new BSTNode<>(r8, null, tree5);
      BSTNode<Chugimon> tree7 = new BSTNode<>(r6);
      BSTNode<Chugimon> tree8 = new BSTNode<>(r7, tree7, tree6);
      BSTNode<Chugimon> tree9 = new BSTNode<>(r5, tree4, tree8);// final tree
      // System.out.println(tree9.getLeft().getData().toString());
      ChugiTree tree10 = new ChugiTree();
      tree10.add(r1);
      tree10.add(r2);
      tree10.add(r3);
      tree10.add(r4);
      tree10.add(r7);
      tree10.add(r5);
      tree10.add(r8);
      tree10.add(r6);
      tree10.add(r9);
      // System.out.println(tree10.toString());
      if (!ChugiTree.isValidBSTHelper(tree9)) {
        return false;
      }
    }

    // scenario 2:non bst(asymmetric)
    {
      // sting the tree
      BSTNode<Chugimon> tree1 = new BSTNode<>(r1);
      BSTNode<Chugimon> tree2 = new BSTNode<>(r4);
      BSTNode<Chugimon> tree3 = new BSTNode<>(r2);
      BSTNode<Chugimon> tree4 = new BSTNode<>(r9);
      BSTNode<Chugimon> tree5 = new BSTNode<>(r3, tree1, tree2);
      BSTNode<Chugimon> tree6 = new BSTNode<>(r6, tree3, null);
      BSTNode<Chugimon> tree7 = new BSTNode<>(r8, null, tree4);
      BSTNode<Chugimon> tree8 = new BSTNode<>(r7, tree6, tree7);
      BSTNode<Chugimon> tree9 = new BSTNode<>(r5, tree5, tree8);
      if (ChugiTree.isValidBSTHelper(tree9)) {
        return false;
      }
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of both add() and toString() methods implemented
   * in the ChugiTree class. This unit test considers at least the following scenarios. (1) Create a
   * new empty ChugiTree, and check that its size is 0, it is empty, and that its string
   * representation is an empty string "". (2) try adding one Chugimon and then check that the add()
   * method call returns true, the tree is not empty, its size is 1, and the toString() called on
   * the tree returns the expected output. (3) Try adding another Chugimon which is less than the
   * Chugimon at the root, (4) Try adding a third Chugimon which is greater than the one at the
   * root, (5) Try adding at least two further Chugimons such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, that the ChugiTree is a valid BST, and that the toString() method returns the expected
   * string representation of the contents of the binary search tree in an increasing order from the
   * smallest to the greatest Chugimon. (6) Try adding a Chugimon already stored in the tree. Make
   * sure that the add() method call returned false, and that the size of the tree did not change.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddToStringSize()
  {
    Chugimon r1 = new Chugimon(1, 6);
    Chugimon r2 = new Chugimon(1, 4);
    Chugimon r3 = new Chugimon(1, 5);
    Chugimon r4 = new Chugimon(1, 7);
    Chugimon r5 = new Chugimon(1, 9);
    Chugimon r6 = new Chugimon(1, 8);
    Chugimon r7 = new Chugimon(1, 3);
    Chugimon r8 = new Chugimon(1, 2);
    Chugimon r9 = new Chugimon(1, 120);
    // TODO complete the implementation of this method
    ChugiTree tree1 = new ChugiTree();

    // scenario 1:adding 1 node
    {
      if (tree1.size() == 0 && tree1.toString().equals("")) {
        try {
          tree1.add(r1);
          // System.out.println(tree1.toString());
          // System.out.println(tree1.size());
          // System.out.println(tree1.getRoot().toString());
          // System.out.println(tree1.toString());
          if (tree1.size() != 1 || !tree1.toString().equals("Bulbizard#1.6")) {
            return false;
          }
        } catch (Exception e) {
          return false;
        }

      } else {
        return false;
      }
    }
    // scenario 2:adding 2nd node
    {
      tree1.add(r1);

      if (tree1.size() == 1 && tree1.toString().equals("Bulbizard#1.6")) {
        try {
          tree1.add(r2);
          // System.out.println(tree1.toString());
          if (tree1.size() != 2 || !tree1.toString().equals("Bulbizard#1.6,Bulbmander#1.4")) {
            return false;
          }
        } catch (Exception e) {
          return false;
        }

      } else {
        return false;
      }
    }
    // scenario 3:adding 1 extra node in a valid bst manner as child
    {
      tree1.add(r1);
      tree1.add(r2);
      try {
        tree1.add(r3);
        // System.out.println(tree1.toString());
        if (tree1.size() != 3
                || !tree1.toString().equals("Bulbizard#1.6,Bulbmander#1.4,Bulbmeleon#1.5")) {
          // System.out.println(tree1.size());
          return false;
        }
      } catch (Exception e) {
        return false;
      }
    }
    // scenario 4:adding a duplicate node
    {
      tree1.add(r1);
      tree1.add(r2);
      tree1.add(r3);
      try {
        boolean check = tree1.add(r2);
        // System.out.println(tree1.toString());
        if (check == true || tree1.size() != 3
                || !tree1.toString().equals("Bulbizard#1.6,Bulbmander#1.4,Bulbmeleon#1.5")) {
          return false;
        }
      } catch (Exception e) {
        return false;
      }
    }
    // scenario 5:Adding a null node
    {
      tree1.add(r1);
      tree1.add(r2);
      tree1.add(r3);
      try {
        tree1.add(null);
        return false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());

      }
    }


    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * This method checks mainly for the correctness of the ChugiTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ChugiTree. Then, check that
   * calling the lookup() method on an empty ChugiTree returns false. (2) Consider a ChugiTree of
   * height 3 which contains at least 5 Chugimons. Then, try to call lookup() method to search for a
   * Chugimon having a match at the root of the tree. (3) Then, search for a Chugimon at the right
   * and left subtrees at different levels considering successful and unsuccessful search
   * operations. Make sure that the lookup() method returns the expected output for every method
   * call.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    ChugiTree tree1 = new ChugiTree();
    Chugimon r1 = new Chugimon(1, 6);// lc of r2
    Chugimon r2 = new Chugimon(1, 4);// lc of r4
    Chugimon r3 = new Chugimon(1, 5);// rc of r2
    Chugimon r4 = new Chugimon(1, 7);// root
    Chugimon r5 = new Chugimon(1, 9);// rc of r4
    Chugimon r6 = new Chugimon(1, 8);// rc of r5
    Chugimon r7 = new Chugimon(1, 3);// rc of r6
    Chugimon r8 = new Chugimon(1, 2);// rc of r7
    Chugimon r9 = new Chugimon(1, 120);// rc of r8
    // scenario 1:searching in an empty tree
    {
      Chugimon collect = tree1.lookup(1, 6);
      if (collect != null) {
        return false;
      }
    }
    // scenario 2:searching in a tree of 5 nodes(height 3)-left search successful
    {
      tree1.add(r1);
      tree1.add(r2);
      tree1.add(r4);
      tree1.add(r6);
      tree1.add(r8);
      tree1.add(r9);
      tree1.add(r7);
      tree1.add(r3);
      tree1.add(r5);
      System.out.println(tree1.toString());
      if (tree1.lookup(1, 5) == null) {
        return false;
      }
    }
    // scenario 3:searching in a tree of 5 nodes-right search successful
    {
      tree1.add(r1);
      tree1.add(r2);
      tree1.add(r4);
      tree1.add(r6);
      tree1.add(r8);
      tree1.add(r9);
      tree1.add(r7);
      tree1.add(r3);
      tree1.add(r5);
      System.out.println(tree1.toString());
      if (tree1.lookup(1, 3) == null) {
        return false;
      }
    }
    // scenario 4:searching in a tree of 5 nodes-node not found
    {
      tree1.add(r1);
      tree1.add(r2);
      tree1.add(r4);
      tree1.add(r6);
      tree1.add(r8);
      tree1.add(r9);
      tree1.add(r7);
      tree1.add(r3);
      tree1.add(r5);
      System.out.println(tree1.toString());
      if (tree1.lookup(1, 80) != null) {
        return false;
      }
    }
    return true;// Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.countType() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCountType()
  {
    Chugimon r1 = new Chugimon(1, 6);
    System.out.println(r1.getPrimaryType()+" "+r1.getSecondaryType());
    Chugimon r2 = new Chugimon(1, 4);
    System.out.println(r2.getPrimaryType()+" "+r2.getSecondaryType());
    Chugimon r3 = new Chugimon(1, 5);
    System.out.println(r3.getPrimaryType()+" "+r3.getSecondaryType());
    Chugimon r4 = new Chugimon(1, 7);
    System.out.println(r4.getPrimaryType()+" "+r4.getSecondaryType());
    Chugimon r5 = new Chugimon(1, 9);
    System.out.println(r5.getPrimaryType()+" "+r5.getSecondaryType());
    Chugimon r6 = new Chugimon(1, 8);
    System.out.println(r6.getPrimaryType()+" "+r6.getSecondaryType());
    Chugimon r7 = new Chugimon(1, 3);
    System.out.println(r7.getPrimaryType()+" "+r7.getSecondaryType());
    Chugimon r8 = new Chugimon(1, 2);
    System.out.println(r8.getPrimaryType()+" "+r8.getSecondaryType());
    Chugimon r9 = new Chugimon(1, 120);
    System.out.println(r9.getPrimaryType()+" "+r9.getSecondaryType());
    ChugiTree tree = new ChugiTree();
    tree.add(r1);

    tree.add(r2);
    tree.add(r4);
    tree.add(r6);
    tree.add(r8);
    tree.add(r9);
    //tree.add(r7);
    tree.add(r3);
    tree.add(r5);
    //scenario 1:when type count is 0
    {
      if(tree.countType(ChugiType.ELECTRIC)!=0)
      {
        return false;
      }
    }

    //scenario 2:when type count is 1
    {
      //System.out.println(tree.countType(ChugiType.WATER));
      if(tree.countType(ChugiType.POISON)!=1)
      {
        return false;
      }
    }

    //scenario 2:when type count is more than 1
    {
      if(tree.countType(ChugiType.FIRE)!=3)
      {
        return false;
      }
    }


    // TODO complete the implementation of this method
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty Chugimon tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ChugiTree with four levels for instance, is 4.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    Chugimon r1 = new Chugimon(1, 6);
    Chugimon r2 = new Chugimon(1, 4);
    Chugimon r3 = new Chugimon(1, 5);
    Chugimon r4 = new Chugimon(1, 7);
    Chugimon r5 = new Chugimon(1, 9);
    Chugimon r6 = new Chugimon(1, 8);
    Chugimon r7 = new Chugimon(1, 3);
    Chugimon r8 = new Chugimon(1, 2);
    Chugimon r9 = new Chugimon(1, 120);
    ChugiTree tree = new ChugiTree();
    // scenario 1:tree is not there
    {
      System.out.println(tree.height());
      if (tree.height() != 0) {

        return false;
      }
    }
    // scenario 2:tree has only 1 node
    {
      tree.add(r2);
      System.out.println(tree.height());
      if (tree.height() != 1) {

        return false;
      }
    }

    //scenario 3:tree is asymmetrical
    {
      tree.add(r5);
      tree.add(r2);
      tree.add(r4);
      tree.add(r3);
      tree.add(r7); tree.add(r6);tree.add(r9);
      tree.add(r8);tree.add(r1);
      System.out.println(tree.height());
      if (tree.height() != 5) {
        System.out.println(tree.height());
        return false;
      }
    }
    // TODO complete the implementation of this method
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.getFirst() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetFirst()
  {
    Chugimon r1 = new Chugimon(1, 6);
    Chugimon r2 = new Chugimon(1, 4);
    Chugimon r3 = new Chugimon(1, 5);
    Chugimon r4 = new Chugimon(1, 7);
    Chugimon r5 = new Chugimon(1, 9);
    Chugimon r6 = new Chugimon(1, 8);
    Chugimon r7 = new Chugimon(1, 3);
    Chugimon r8 = new Chugimon(1, 2);
    Chugimon r9 = new Chugimon(1, 120);
    ChugiTree tree = new ChugiTree();
    //scenario 1:there is only one node
    {
      tree.add(r2);
      if(!(tree.getFirst().compareTo(r2)==0))
      {
        return false;
      }
    }
    //scenario 2:there is only 1 left child of the argument
    {
      tree.add(r2);
      tree.add(r1);
      if(!(tree.getFirst().compareTo(r1)==0))
      {
        return false;
      }
    }

    //scenario 3:there are 2 or more left children
    {
      ChugiTree tree1=new ChugiTree();
      tree1.add(r5);
      tree1.add(r3);
      tree1.add(r7);
      tree1.add(r6);
      //tr1ee.add(r1);
      tree1.add(r4);
      //System.out.println(tree1.getFirst().toString());
      if(!(tree1.getFirst().compareTo(r3)==0))
      {
        return false;
      }
    }

    // TODO complete the implementation of this method
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.getLast() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetLast() {
    Chugimon r1 = new Chugimon(1, 6);
    Chugimon r2 = new Chugimon(1, 4);
    Chugimon r3 = new Chugimon(1, 5);
    Chugimon r4 = new Chugimon(1, 7);
    Chugimon r5 = new Chugimon(1, 9);
    Chugimon r6 = new Chugimon(1, 8);
    Chugimon r7 = new Chugimon(1, 3);
    Chugimon r8 = new Chugimon(1, 2);
    Chugimon r9 = new Chugimon(1, 120);
    ChugiTree tree = new ChugiTree();
    //scenario 1:there is only one node
    {
      tree.add(r2);
      if(!(tree.getLast().compareTo(r2)==0))
      {
        return false;
      }
    }
    //scenario 2:there is 1 right child
    {
      tree.add(r2);
      tree.add(r3);
      if(!(tree.getLast().compareTo(r3)==0))
      {
        return false;
      }
    }
    //scenario 3:there are more than 2 right children
    {
      //tree.add(r1);

      tree.add(r2);
      tree.add(r4);
      tree.add(r6);
      tree.add(r8);
      tree.add(r9);
      tree.add(r7);
      tree.add(r3);
      tree.add(r5);
      if(!(tree.getLast().compareTo(r9)==0))
      {
        return false;
      }
    }
    // TODO complete the implementation of this method
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.delete() method. This test must consider at least 3
   * test scenarios. (1) Remove a Chugimon that is at leaf node (2) Remove a Chugimon at non-leaf
   * node. For each of these scenarios, check that the size of the tree was decremented by one and
   * that the resulting ChugiTree is a valid BST, (3) ensures that the ChugiTree.delete() method
   * returns false when called on an Chugimon that is not present in the BST.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testDelete() {
    // case 1 - Remove a Chugimon that is at leaf node
    ChugiTree chugiTree=new ChugiTree();
    {
      try {
        Chugimon chug1=new Chugimon(1,2); // Bulbysaur#1.2
        Chugimon chug2=new Chugimon(1,3); // Bulbusaur#1.3
        chugiTree.add(chug1);
        chugiTree.add(chug2);
        chugiTree.delete(chug2);
        if (chugiTree.size()!=1 ||
                !chugiTree.toString().equals("Bulbysaur#1.2")){
          System.out.println(chugiTree);
          System.out.println("case 1 is returning false");
          return false;
        }
      }
      catch (Exception e){
        e.printStackTrace();
        return false;
      }
    }

    // case 2 - Remove a Chugimon at non-leaf node
    {
      try {
        Chugimon chug1=new Chugimon(1,2); // Bulbysaur#1.2
        Chugimon chug2=new Chugimon(1,3); // Bulbusaur#1.3
        chugiTree.add(chug1);
        chugiTree.add(chug2);
        chugiTree.delete(chug1);
        if (chugiTree.size()!=1 ||
                !chugiTree.toString().equals("Bulbusaur#1.3")){
          System.out.println("case 2 is returning false");
          return false;
        }
      }
      catch (Exception e){
        e.printStackTrace();
        return false;
      }
    }
    // case 3 - ensures that the ChugiTree.delete() method returns false
    // when called on an Chugimon that is not present in the BST.
    {
      try {
        Chugimon chug3=new Chugimon(1,5); // Bulbmeleon#1.5
        if (chugiTree.delete(chug3)){
          System.out.println("case 3 is returning unexpected result");
          return false;
        }
      }
      catch (Exception e){
        e.printStackTrace();
        return false;
      }
    }


    // case 4 - when successor has a child
    {
      try {
        Chugimon chug1=new Chugimon(1,2); // Bulbysaur#1.2
        Chugimon chug2=new Chugimon(1,3); // Bulbusaur#1.3
        Chugimon chug3=new Chugimon(1,4); // Bulbmander#1.4
        Chugimon chug4=new Chugimon(1,5); // Bulbmeleon#1.5

        chugiTree.add(chug4);
        chugiTree.add(chug1);
        chugiTree.add(chug3);
        chugiTree.add(chug2);
        chugiTree.delete(chug1);
        if (chugiTree.size()!=3 ||
                !chugiTree.toString().equals("Bulbmander#1.4,Bulbmeleon#1.5,Bulbusaur#1.3")){
          System.out.println("case 4 is returning false");
          System.out.println(chugiTree);
          return false;
        }
      }
      catch (Exception e){
        e.printStackTrace();
        return false;
      }
    }

    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.next() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testNext()
  {
    Chugimon r1 = new Chugimon(1, 6);
    Chugimon r2 = new Chugimon(1, 4);
    Chugimon r3 = new Chugimon(1, 5);
    Chugimon r4 = new Chugimon(1, 7);
    Chugimon r5 = new Chugimon(1, 9);
    Chugimon r6 = new Chugimon(1, 8);
    Chugimon r7 = new Chugimon(1, 3);
    Chugimon r8 = new Chugimon(1, 2);
    Chugimon r9 = new Chugimon(1, 120);
    ChugiTree tree = new ChugiTree();
    tree.add(r2);
    tree.add(r4);
    tree.add(r6);
    tree.add(r8);
    tree.add(r9);
    tree.add(r7);
    tree.add(r3);
    tree.add(r5);
    // TODO complete the implementation of this method

    //scenario 1:when argument chugi is null
    {
      try {
        tree.next(null);
        return false;}
      catch(IllegalArgumentException e)
      {

      }

    }
    //scenario 2:when argument has a successor
    {
      try {
        if(!(tree.next(r2).compareTo(r3)==0))
        {
          return false;
        }
      }
      catch(Exception e)
      {
        return false;
      }
    }
    //scenario 3:when argument has no right child
    {
      try {
        if(!(tree.next(r6).compareTo(r7)==0))
        {
          return false;
        }
      }
      catch(Exception e)
      {
        return false;
      }
    }
    //scenario 3bwhen there is no potential successor and the argument doesn't have a right child
    {
      try {
        tree.next(r9);
        return false;
      }
      catch(NoSuchElementException e)
      {

      }
      catch(Exception e)
      {
        return false;
      }
    }

    //scenario 4:when argument has left nodes but no right node
    {
      try {
        if(!(tree.next(r4).compareTo(r5)==0))
        {
          return false;
        }
      }
      catch(Exception e)
      {
        return false;
      }
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.previous() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPrevious() {
    Chugimon r1 = new Chugimon(1, 6);
    Chugimon r2 = new Chugimon(1, 4);
    Chugimon r3 = new Chugimon(1, 5);
    Chugimon r4 = new Chugimon(1, 7);
    Chugimon r5 = new Chugimon(1, 9);
    Chugimon r6 = new Chugimon(1, 8);
    Chugimon r7 = new Chugimon(1, 3);
    Chugimon r8 = new Chugimon(1, 2);
    Chugimon r9 = new Chugimon(1, 120);
    ChugiTree tree = new ChugiTree();
    tree.add(r2);
    tree.add(r4);
    tree.add(r6);
    tree.add(r8);
    tree.add(r9);
    tree.add(r7);
    tree.add(r3);
    tree.add(r5);
    // TODO complete the implementation of this method
    //scenario 1:argument chugi is null

    {
      try {
        tree.previous(null);
        return false;}
      catch(IllegalArgumentException e)
      {

      }
    }

    //scenario 2:argument  has a predecessor
    {
      try {
        System.out.println(tree.previous(r4).toString());
        if(!(tree.previous(r4).compareTo(r3)==0))
        {
          return false;
        }
      }
      catch(Exception e)
      {
        return false;
      }
    }


    //scenario 3:argument has no left child
    {
      try {
        System.out.println(tree.previous(r6).toString());
        if(!(tree.previous(r6).compareTo(r5)==0))
        {
          return false;
        }
      }
      catch(Exception e)
      {
        return false;
      }
    }


    //scenario 3b:when there is no potential predecessor and the argument doesn't have a left child
    {
      try {
        tree.previous(r2);
        return false;
      }
      catch(NoSuchElementException e)
      {

      }
      catch(Exception e)
      {
        return false;
      }
    }

    return true;
  }

  /**
   * Calls the test methods
   *
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testChugimonCompareToEquals: " + testChugimonCompareToEquals());
    System.out.println("testChugimonToString(): " + testChugimonToString());
    System.out.println("testIsValidBSTHelper(): " + testIsValidBSTHelper());
    System.out.println("testAddToStringSize(): " + testAddToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testCountType(): " + testCountType());
    System.out.println("testGetFirst(): " + testGetFirst());
    System.out.println("testGetLast(): " + testGetLast());
    System.out.println("testDelete(): " + testDelete());
    System.out.println("testNext(): " + testNext());
    System.out.println("testPrevious(): " + testPrevious());
  }

}