/*
create
Contains, Delete, FindMin, Find Max, insert
 */


package Classwork;

import java.util.Comparator;

public class BinarySearchTree<AnyType extends Comparable<AnyType>> {



	private static BinaryNode root;
	private Comparator<? super AnyType> cmp;

	public BinarySearchTree(){
		this(null);
	}

	public BinarySearchTree(Comparator<? super AnyType> c) {
		root = null;
		cmp = c;
	}

	public int myCompare(AnyType lhs, AnyType rhs){
		if(cmp != null)
			return cmp.compare(lhs,rhs);
		else
			return ((Comparable)lhs).compareTo(rhs);
	}

	private boolean contains(AnyType x, BinaryNode<AnyType> t){
		if(t == null)
			return false;

		int compareResult = myCompare( x, t.element );

		 if( compareResult < 0 )
			 return contains( x, t.left );
		 else if( compareResult > 0 )
		 	return contains( x, t.right );
		 else
		 	return true; // Match
	}

	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if(t == null)
			return null;
		else if (t.left == null)
			return t;
		return findMin(t.left);
	}

	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
		if(t != null)
			while(t.right != null)
				t = t.right;

		return t;
	}

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
		if(t == null)
			return new BinaryNode<>(x, null,null);
		int compareResult = x.compareTo( t.element );

		 if( compareResult < 0 )
			 t.left = insert( x, t.left );
		 else if( compareResult > 0 )
		 	t.right = insert( x, t.right );
		 else
		 	; // Duplicate; do nothing
		 return t;
	}

	private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t ) {
	 if( t == null )
		 return t; // Item not found; do nothing

		 int compareResult = x.compareTo( t.element );

		 if( compareResult < 0 )
		 	t.left = remove( x, t.left );
		 else if( compareResult > 0 )
		 	t.right = remove( x, t.right );
		 else if( t.left != null && t.right != null ){ // Two children
			t.element = findMin( t.right ).element;
			t.right = remove( t.element, t.right );
		 }
		 else
			 t = ( t.left != null ) ? t.left : t.right;
		 return t;
	}

	public void printRange(AnyType k1, AnyType k2, BinaryNode<AnyType> t){

		if(t == null)
			return ;

		if (t.getElement().compareTo(k1) > 0 && t.getElement().compareTo(k2) < 0) {
			System.out.println(t.getElement());
			printRange(k1,k2,t.getRight());
			printRange(k1,k2,t.getLeft());
		}
		if (t.getElement().compareTo(k1) < 0)
			printRange(k1,k2,t.getRight());
		else
			printRange(k1,k2,t.getLeft());

	}

	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();


	}
}
