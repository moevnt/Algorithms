/*
create
Contains, Delete, FindMin, Find Max, insert
 */


package Classwork;

public class BinarySearchTree<AnyType extends Comparable<AnyType>> {

	private BinaryNode<AnyType> root;

	public BinarySearchTree(AnyType root){
		this.root = new BinaryNode<AnyType>(root, null, null);
	}

	public BinarySearchTree(){
		root = null;
	}

	public AnyType findMin(BinaryNode x){
		if(x.getLeft() != null)
			return findMin(x.getLeft());

		else
			return (AnyType) x.getElement();
	}

	public AnyType findMax(BinaryNode x){
		if(x.getRight() != null)
			return findMax(x.getRight());

		else
			return (AnyType) x.getElement();
	}

	public boolean contains(AnyType key, BinaryNode t){
		if(t == null)
			return false;

		int num = key.compareTo((AnyType) t.getElement());
		if(num < 0)
			return contains(key, t.getLeft());
		else
			return contains(key, t.getRight());
	}

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){

		if(t == null)
			return new BinaryNode<>(x, null, null);

		int compareResult = x.compareTo(t.getElement());

		if(compareResult < 0)
			t.left = insert(x, t.left);
		else if(compareResult > 0)
			t.right = insert(x, t.right);
		else
			;

		return t;
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {

		if(t == null)
			return t;

		int compareResult = x.compareTo(t.getElement());

		if(compareResult < 0)
			t.left = remove(x, t.left);
		else if(compareResult > 0)
			t.right = remove(x, t.right);
		else if(t.left != null && t.right != null) {
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		}
		else
			t = (t.left != null) ? t.left : t.right;

		return t;

	}


	}
