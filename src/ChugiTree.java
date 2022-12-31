
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
 * This class implements a ChugidexStorage as a Binary Search Tree.
 *
 * Notes: 1) You may NOT use any arrays or Collections objects (ArrayLists, etc)
 * in this class. 2)
 * You may NOT use any loops (for, while, etc) in this class. Recursive
 * strategies only.
 *
 */
public class ChugiTree implements ChugidexStorage {

  /**
   * The root of this ChugiTree. Set to null when tree is empty.
   */
  private BSTNode<Chugimon> root;

  /**
   * The size of this ChugiTree (total number of Chugimon stored in this BST)
   */
  private int size;

  /**
   * Constructor for Chugitree. Should set size to 0 and root to null.
   */
  public ChugiTree()
  {
    size = 0;
    root = null;
  }

  /**
   * Getter method for the Chugimon at the root of this BST.
   *
   * @return the root of the BST.
   */
  public Chugimon getRoot() {

    return root.getData();
  }

  /**
   * A method for determining whether this ChugiTree is a valid BST. In
   * order to be a valid BST, the following must be true: For every internal
   * (non-leaf) node X of a binary tree, all the values in the node's left subtree
   * are less than the value in X, and all the values in the node's right subtree
   * are greater than the value in X.
   *
   * @return true if this ChugiTree is a valid BST, false otherwise
   */
  public boolean isValidBST() {
    return isValidBSTHelper(root);
  }

  /**
   * A helper method for determining whether this ChugiTree is a valid BST. In
   * order to be a valid BST, the following must be true: For every internal
   * (non-leaf) node X of a binary tree, all the values in the node's left subtree
   * are less than the value in X, and all the values in the node's right subtree
   * are greater than the value in X.
   *
   * @param node The root of the BST.
   * @return true if the binary tree rooted at node is a BST, false otherwise
   */
  public static boolean isValidBSTHelper(BSTNode<Chugimon> node)
  {
    if (node==null){
      return true;
    }

    BSTNode<Chugimon> l_child=node.getLeft();
    BSTNode<Chugimon> r_child=node.getRight();
    if (!isValidBSTHelper(l_child) || !isValidBSTHelper(r_child)){

      return false;
    }

    if (l_child!=null){

      if (node.getData().compareTo(l_child.getData())<=0){
        return false;//even when data is equal-no duplicates
      }
      Chugimon predecessor_node=getLastHelper(l_child); //for a special case when there is
      //an invalid node in a subtree but it satisfies child-parent subtree relationship


      if (node.getData().compareTo(predecessor_node)<=0){
        return false;
      }

    }
    if (r_child!=null){

      if (node.getData().compareTo(r_child.getData())>=0){
        return false;
      }


      Chugimon succeeding_node=getFirstHelper(r_child); //for a special case when there is an
      //invalid node in a subtree but it satisfies child-parent subtree relationship

      return (node.getData().compareTo(succeeding_node) < 0);
    }
    return true;
  }

  /**
   * Checks whether this ChugiTree is empty or not
   *
   * @return true if this tree is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    // TODO implement this method
    return this.size() == 0;// default return statement
  }

  /**
   * Gets the size of this ChugiTree
   *
   * @return the total number of Chugimons stored in this tree
   */
  @Override
  public int size() {

    return size; // default return statement
  }

  /**
   * Returns a String representation of all the Chugimons stored within this
   * ChugiTree in the
   * increasing order with respect to the result of Chugimon.compareTo() method.
   * The string should
   * be a comma-separated list of all the Chugimon toString() values. No spaces
   * are expected to be
   * in the resulting string. No comma should be at the end of the resulting
   * string. For instance,
   *
   * "nameOne#12.25,nameTwo#12.56,nameTwo#89.27"
   *
   * @return a string containing all of the Chugimon, in the increasing order.
   *         Returns an empty
   *         string "" if this BST is empty.
   *
   */
  @Override
  public String toString() {
    String s = toStringHelper(root);
    // if(s.length()!=0)
    // {
    // return s.substring(0,s.length()-1);}
    // else {
    return s;
//    String s = toStringHelper(root);
//    if(s.length() == 0)
//    {
//      return "";
//    }
//    else
//    {
//       return s.substring(0, s.length() - 1);
//    }
  }

  /**
   * Recursive helper method which returns a String representation of the
   * ChugiTree rooted at node. An example of the String representation of the
   * contents of a ChugiTree storing three Chugimons is provided in the
   * description of the above toString() method.
   *
   * @param node references the root of a subtree
   * @return a String representation of all the Chugimons stored in the sub-tree
   *         rooted at node in
   *         increasing order. Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Chugimon> node) {
    //we do in-order traversal on a valid BST-left,self,right
    //we go till the end left-store it,then go to parent(self),store it,then go to right(store it)
    //then we go to parent of parent(self),then right-again keep going left till we reach leaf node
    //in every sub and subsub trees and so on
    String s = "";// store 1 level-left,self,right
    if (node == null) {
      return "";
    } else {

      Chugimon data = node.getData();
      String left = toStringHelper(node.getLeft());
      s += left;
      if (left != "") {
        s += ",";
      }
      s += data.toString();// getting current node's data-add after left
      String right = toStringHelper(node.getRight());
      if (right != "") {
        s += ",";
      }
      s += right;
      // if(right!="")
      // {
      // s+=",";
      // }
      return s;

    }
  }

  /**
   * Adds a new Chugimon to this ChugiTree. Duplicate Chugimons are NOT allowed.
   *
   * @param newChugimon Chugimon to add to this ChugiTree
   * @return true if if the newChugimon was successfully added to the ChugiTree,
   *         false if a match with newChugimon is already present in the tree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  newChugimon is null.
   */
  @Override
  public boolean add(Chugimon newChugimon) {
    if (newChugimon == null) {
      throw new IllegalArgumentException("the incoming node is null");
    }
    if (root == null) {
      root = new BSTNode<Chugimon>(newChugimon);
      size++;
      return true;
    }

    else {
      boolean check = addHelper(newChugimon, root);
      if (check) {
        size++;
      }
      return check;

    }
//    else if(addHelper(newChugimon,root))
//    {
//      size++;
//      return true;
//    }
//    else
//    {
//      return false;
//    }
  }

  /**
   * Recursive helper method to insert a new Chugimon to a Pokedex rooted at node.
   *
   * @param node        The "root" of the subtree we are inserting the new
   *                    Chugimon into.
   * @param newChugimon The Chugimon to be added to a BST rooted at node. We
   *                    assume that newChugimon is NOT null.
   * @return true if the newChugimon was successfully added to the ChugiTree,
   *         false if a match with
   *         newChugimon is already present in the subtree rooted at node.
   */
  protected static boolean addHelper(Chugimon newChugimon, BSTNode<Chugimon> node){
    // TODO implement this method
    if (node == null) {
      return true;
    }
    if (node.getData().compareTo(newChugimon) == 0)// duplicates
    {
      return false;
    } else if (node.getData().compareTo(newChugimon) > 0) {
      // should it be after the if
      // statement in an else block
      if (node.getLeft() == null) {
        node.setLeft(new BSTNode<Chugimon>(newChugimon));
        // return true;
      } else {
        if (!addHelper(newChugimon, node.getLeft())) {
          return false;
        }
      }
    }
    // boolean check_left_child=addHelper(newChugimon,node.getLeft());
    // if(check_left_child==true )
    // {
    // node.setLeft(new BSTNode(newChugimon));
    // return true;
    // }

    else if (node.getData().compareTo(newChugimon) < 0) {

      if (node.getRight() == null) {
        node.setRight(new BSTNode<Chugimon>(newChugimon));
        // return true;
      } else {
        if (!addHelper(newChugimon, node.getRight())) {
          return false;
        }
      }
    }
    return true; // default return statement
  }

  /**
   * Searches a Chugimon given its first and second identifiers.
   *
   * @param firstId  First identifier of the Chugimon to find
   * @param secondId Second identifier of the Chugimon to find
   * @return the matching Chugimon if match found, null otherwise.
   */
  @Override
  public Chugimon lookup(int firstId, int secondId) {
    // TODO Implement this method.
    Chugimon collect=lookupHelper(new Chugimon(firstId,secondId),root);
    return collect;
  }

  /**
   * Recursive helper method to search and return a match with a given Chugimon in
   * the subtree rooted at node, if present.
   *
   * @param toFind a Chugimon to be searched in the BST rooted at node. We assume
   *               that toFind is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a
   *               match to target.
   * @return a reference to the matching Chugimon if found, null otherwise.
   */
  protected static Chugimon lookupHelper(Chugimon toFind, BSTNode<Chugimon> node)
  {
    //stop only when we reach the end node or node is found
    Chugimon collect;
    if(node==null)
    {
      return null;//we only go till the null node on one side of the subtree when we haven't
      //found the node yet

    }

    else {
      if(node.getData().compareTo(toFind)==0)
      {
        return toFind;
      }
      else if(node.getData().compareTo(toFind)>0)
      {
        collect=lookupHelper(toFind,node.getLeft());
      }
      else {
        collect=lookupHelper(toFind,node.getRight());
      }
    }
    return collect;
  }

  /**
   * Computes and returns the height of this BST, counting the number of NODES
   * from root to the deepest leaf.
   *
   * @return the height of this Binary Search Tree
   */
  public int height()
  {

    return heightHelper(root); // Default return statement
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at
   * node counting the number of nodes and NOT the number of edges from node to
   * the deepest leaf
   *
   * @param node root of a subtree
   * @return height of the subtree rooted at node
   */
  protected static int heightHelper(BSTNode<Chugimon> node)
  {
    if(node==null)
    {
      return 0;
    }
    else {
      int left_height=heightHelper(node.getLeft())+1;
      int right_height=heightHelper(node.getRight())+1;
      return Math.max(left_height,right_height);
    }
  }

  /**
   * Recursive method to find and return the first Chugimon, in the increasing
   * order, within this ChugiTree (meaning the smallest element stored in the
   * tree).
   *
   * @return the first element in the increasing order of this BST, and null if
   *         the tree is empty.
   */
  @Override
  public Chugimon getFirst() {
    // TODO Implement this method.

    // HINT: The smallest element in a non-empty BST is the left most element


    return getFirstHelper(root); // default return statement
  }

  /**
   * Recursive helper method for getFirst().
   *
   * @param root the node from which to find the the minimum node
   * @return the minimum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getFirstHelper(BSTNode<Chugimon> root) {
    if (root == null) {
      return null;
    } else {
      Chugimon collect = getFirstHelper(root.getLeft());
      if (collect == null) {
        return root.getData();
      } else {
        return collect;
      }

      // HINT: The smallest element in a non-empty BST is the left most element
      // default return statement
    }
  }

  /**
   * Recursive method to find and return the last Chugimon, in the increasing
   * order, within this ChugiTree (meaning the greatest element stored in the
   * tree).
   *
   * @return the last element in the increasing order of this BST, and null if the
   *         tree is empty.
   */
  @Override
  public Chugimon getLast() {
    // TODO Implement this method.

    // HINT: The greatest element in a non-empty BST is the right most element

    return getLastHelper(root);// default return statement
  }

  /**
   * Recursive helper method for getLast().
   *
   * @param root the node from which to find the the maximum node
   * @return the maximum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getLastHelper(BSTNode<Chugimon> root) {
    if (root == null) {
      return null;
    } else {
      Chugimon collect = getLastHelper(root.getRight());
      if (collect == null) {
        return root.getData();
      } else {
        return collect;
      }
    }
  }




  /**
   * Recursive method to get the number of Chugimon with a primary or secondary
   * type of the specified type, stored in this ChugiTree.
   *
   * @param chugiType the type of Chugimons to count. We assume that chugiType is
   *                  NOT null.
   * @return the number of all the Chugimon objects with a primary or secondary
   *         type of the
   *         specified type stored in this ChugiTree.
   */
  public int countType(ChugiType chugiType)
  {
    return traverse(chugiType,root);
  }

  /**
   * Method to traverse through tree
   *
   * @param collect - ChugiType of chugimon
   * @param node - Node (root) to start at for traversal
   * @return - number of chugimon of certain chugiType in Tree
   */
  private static int traverse(ChugiType collect, BSTNode<Chugimon> node)
  {
    int count = 0;

    if (node == null) {
      return count;
    } else {
      if (node.getData().getPrimaryType() == collect
              || node.getData().getSecondaryType() == collect) {
        count += 1;
      }
      count += traverse(collect, node.getLeft());
      count += traverse(collect, node.getRight());
      return count;
    }

  }

  /**
   * Finds and returns the in-order successor of a specified Chugimon in this
   * ChugiTree
   *
   * @param chugi the Chugimon to find its successor
   * @return the in-order successor of a specified Chugimon in this ChugiTree
   *
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   with a descriptive error message if the
   *                                  Chugimon provided as input has no in-order
   *                                  successor in this ChugiTree.
   */
  @Override
  public Chugimon next(Chugimon chugi) {
    if (chugi == null) {
      throw new IllegalArgumentException("the argument chugimon is null");
    }
    return nextHelper(chugi, root, null);
  }

  /**
   * Recursive helper method to find and return the next Chugimon in the tree
   * rooted at node.
   *
   * @param chugi a Chugimon to search its in-order successor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param next  a BSTNode which stores a potentional candidate for next node
   * @return the next Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the
   *                                Chugimon provided as input has no in-order
   *                                successor in the subtree
   *                                rooted at node.
   */
  protected static Chugimon nextHelper(Chugimon chugi, BSTNode<Chugimon> node, BSTNode next) throws NoSuchElementException {
    // TODO: Implement this method.
    // Hint: you will need to use getFirstHelper in this method. Below are
    // additional hints.

    // base case: node is null

    // recursive cases:
    // (1) if chugi is found and if the right child is not null, use getFirstHelper
    // to find and
    // return the next chugimon. It should be the left most child of the right
    // subtree

    // (2) if chugi is less than the Chugimon at node, set next as the root node and
    // search
    // recursively into the left subtree

    Chugimon collect = null;// can we make collect null in every recursive call-i think we can
    // because
    // we are only initializing collect and not using it
    if (node == null) {
      return null;
    } else {
      if (node.getData().compareTo(chugi) > 0) {
        next = node;
        collect = nextHelper(chugi, node.getLeft(), next);
      } else if (node.getData().compareTo(chugi) < 0) {
        collect = nextHelper(chugi, node.getRight(), next);
      } else

      {
        if (node.getRight() == null) {
          if(next==null)
          {
            return null;
          }
          else {
            return (Chugimon) ((next).getData());}
        } else {
          collect = getFirstHelper(node.getRight());
        }
      }
      if (collect == null) {
        throw new NoSuchElementException("there is no successor to the argument node");
      } else {
        return collect;
      }
    }
  }

  /**
   * Finds and returns the in-order predecessor of a specified Chugimon in this
   * ChugiTree
   *
   * @param chugi the Chugimon to find its predecessor
   * @return the in-order predecessor of a specified Chugimon in this ChugiTree.
   *
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   if there is no Chugimon directly before the
   *                                  provided Chugimon
   */
  @Override
  public Chugimon previous(Chugimon chugi) throws IllegalArgumentException, NoSuchElementException {
    if (chugi == null) {
      throw new IllegalArgumentException("the argument chugimon is null");
    }
    return previousHelper(chugi, root, null);
  }

  /**
   * Recursive helper method to find and return the previous Chugimon in the tree
   * rooted at node.
   *
   * @param chugi a Chugimon to search its in-order predecessor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param prev  a BSTNode which stores a potentional candidate for previous node
   * @return the previous Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the
   *                                Chugimon provided as input has no in-order
   *                                predecessor in the subtree rooted at node.
   */
  protected static Chugimon previousHelper(Chugimon chugi, BSTNode<Chugimon> node,
                                           BSTNode<Chugimon> prev) throws NoSuchElementException {
    // TODO Implement this method.
    // Hint: you will need to use getLastHelper in this method. Below are more
    // hints.

    // base case: node is null

    // recursive cases:
    // (1) if chugi is found and if the left child is not null, use getLastHelper to
    // find and return
    // the previous chugimon. It should be the right most child of the left subtree

    // (2) if chugi is greater than the Chugimon at node, set prev as the root node
    // and search
    // recursively into the right subtree
    Chugimon collect = null;
    if (node == null) {
      return null;
    } else {
      if (node.getData().compareTo(chugi) < 0) {
        if(prev==null)
        {
          prev = node;}
        else {
          if(prev.getData().compareTo(node.getData())>0)
          {
            prev=node;
          }
        }
        collect = previousHelper(chugi, node.getRight(), prev);
      }
      else if (node.getData().compareTo(chugi) > 0) {

        collect = previousHelper(chugi, node.getLeft(), prev);
      }  else

      {
        if (node.getLeft() == null) {
          if(prev!=null)
          {
            return (Chugimon) ((prev).getData());}
          else {
            collect=null;
          }
        } else {
          collect = getLastHelper(node.getLeft());
        }
      }
      if (collect == null) {
        throw new NoSuchElementException("there is no successor to the argument node");
      } else {
        return collect;
      }
    }
  }

  /**
   * Deletes a specific Chugimon from this ChugiTree.
   *
   * @param chugi the Chugimon to delete
   * @return true if the specific Chugimon is successfully deleted, false if no
   *         match found with any
   *         Chugimon in this tree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   */
  @Override
  public boolean delete(Chugimon chugi) throws IllegalArgumentException
  {
    if (chugi==null){
      throw new IllegalArgumentException("Chugi is null");
    }
    try {
      root=deleteChugimonHelper(chugi,root);
      size--;
    }
    catch (NoSuchElementException n){
      return false;
    }
    return true;
  }

  /**
   * Recursive helper method to search and delete a specific Chugimon from the BST
   * rooted at node
   *
   * @param target a reference to a Chugimon to delete from the BST rooted at
   *               node. We assume that target is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a
   *               match with the target Chugimon.
   *
   *
   * @return the new "root" of the subtree we are checking after trying to remove
   *         target
   * @throws NoSuchElementException with a descriptive error message if there is
   *                                no Chugimon matching target in the BST rooted
   *                                at <b>node</b>
   */
  protected static BSTNode<Chugimon> deleteChugimonHelper(Chugimon target, BSTNode<Chugimon> node) throws NoSuchElementException {
    // TODO complete the implementation of this method. Problem decomposition and
    // hints are provided in the comments below

    // if node == null (empty subtree rooted at node), no match found, throw an
    // exception
    if (node==null){
      throw new NoSuchElementException("target not found or node is null");
    }


    int compare=target.compareTo(node.getData());

    if (compare==0){ // they are equal
      if (node.getLeft()==null && node.getRight()==null)
      { // level 1 - no children
        node=null;
      }
      else if (node.getLeft()!=null && node.getRight()==null)
      { // level 2 - only left child
        node=node.getLeft();
      }
      else if (node.getLeft()==null && node.getRight()!=null)
      { // level 2 - only right child
        node=node.getRight();
      }
      else { // level 3 - has both children
        // Chugimon that is the successor of the current Chugimon
        Chugimon s =getFirstHelper(node.getRight());
        BSTNode<Chugimon> sNode=getNodeinBST(s,node); // gives us the node where the successor is
        node=sNode; // node of successor replaces the node with its succeeding node
        BSTNode<Chugimon> rOfS=sNode.getRight();
        BSTNode<Chugimon> pOfS=getParent(s,node);
        pOfS.setLeft(rOfS); // hooks the right child of the successor
        // to the parent of successor, thus removing it

      }
    }
    else if (compare>0) { // target Chugimon is greater
      node.setRight(deleteChugimonHelper(target, node.getRight()));
    }
    else { // target chugimon is smaller
      node.setLeft(deleteChugimonHelper(target, node.getLeft()));
    }


    // Compare the target to the data at node and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the
    // left or the right child of node accordingly


    // if match with target found, three cases should be considered. Feel free to
    // organize the order of these cases at your choice.

    // Case 1: node may be a leaf (has no children), set node to null.

    // Case 2: node may have only one child, set node to that child (whether left or
    // right child)

    // Case 3: node may have two children,
    // Replace node with a new BSTNode whose data field value is the successor of
    // target in the tree, and having the same left and right children as node.
    // Notice carefully that you cannot set the data of a BSTNode. Hint: The
    // successor is the smallest element at the right subtree of node
    //
    // Then, remove the successor from the right subtree. The successor must have up
    // to one child.

    // Make sure to return node (the new root to this subtree) at the end of each
    // case or at the end of the method.

    return node; // Default return statement added to resolve compiler errors

    // if match with target found, three cases should be considered. Feel free to
    // organize the order of these cases at your choice.

    // Case 1: node may be a leaf (has no children), set node to null.

    // Case 2: node may have only one child, set node to that child (whether left or
    // right child)

    // Case 3: node may have two children,
    // Replace node with a new BSTNode whose data field value is the successor of
    // target in the tree, and having the same left and right children as node.
    // Notice carefully that you cannot set the data of a BSTNode. Hint: The
    // successor is the smallest element at the right subtree of node
    //
    // Then, remove the successor from the right subtree. The successor must have up
    // to one child.

    // Make sure to return node (the new root to this subtree) at the end of each
    // case or at the end of the method.

    // Default return statement added to resolve compiler errors

  }

  /**
   * Private Helper method to get the Node for a given Chugimon successor
   *
   * @param toFind -  chugimon to find in tree
   * @param node - The node to start with
   *
   * @return the BSTNode<Chugimon> of successor chugimon
   */
  private static BSTNode<Chugimon> getNodeinBST(Chugimon toFind, BSTNode<Chugimon> node){
    if (node==null) {
      // not found
      return null;
    }
    if (toFind.compareTo(node.getData())<0){
      // less than current node so check left subtree
      return getNodeinBST(toFind,node.getLeft());
    } else if (toFind.compareTo(node.getData())>0) {
      // greater than current node so checks left subtree
      return getNodeinBST(toFind,node.getRight());
    }
    // node found
    return node;
  }

  /**
   * Private Helper method to get the parent of successor chugimon
   *
   * @param toFind - chugimon to find in tree
   * @param node - The node to start with
   *
   * @return the BSTNode<Chugimon> parent of successor chugimon
   */
  private static BSTNode<Chugimon> getParent(Chugimon toFind, BSTNode<Chugimon> node){
    if (node==null) {
      // not found
      return null;
    }
    if (toFind.compareTo(node.getData())<0){
      // less than current node so check left subtree
      return getNodeinBST(toFind,node.getLeft());
    } else if (toFind.compareTo(node.getData())>0) {
      // greater than current node so checks left subtree
      return getNodeinBST(toFind,node.getRight());
    }
    // node found
    return node;
  }

}