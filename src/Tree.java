public class Tree <T extends Comparable<T>>{
    private Node root;


    public Tree()
    {
        root = null;
    }



    public void insert(Words data)
    {
        root = insert(data, root);
    }


    private int height(Node t )
    {
        return t == null ? -1 : t.height;
    }


    private int max(int lhs, int rhs)
    {
        return Math.max(lhs, rhs);
    }



    private Node insert(Words val, Node t)
    {
        if (t == null)
            t = new Node(val);
        else if(t.getData().compareTo(val) < 0)
        { //System.out.println("In left insertion");
            t.setLeft(insert(val,t.getLeft()));

            if( height( t.getLeft() ) - height( t.getRight() ) == 2 )
                if( t.getData().compareTo(val)<0 )
                {
                    System.out.println("in ll case");
                    t = rotateWithLeftChild( t );
                }
                else
                    t = doubleWithLeftChild( t );
        }
        else if( t.getData().compareTo(val)>0 )
        {
            t.setRight(insert(val,t.getRight()));
            if( height( t.getRight() ) - height( t.getLeft() ) == 2 )
                if( t.getData().compareTo(val)>0)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
            ;

        t.height = max( height( t.getLeft() ), height( t.getRight() ) ) + 1;
        return t;
    }

    //right rot
    private Node rotateWithLeftChild(Node k2)
    {
        Node k1=k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.height = max( height( k2.getLeft() ), height( k2.getRight() ) ) + 1;
        k1.height = max( height( k1.getLeft() ), k2.height ) + 1;
        return k1;
    }

// left rotation
    private Node rotateWithRightChild(Node k1)
    {
        Node k2=k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.height = max( height( k1.getLeft() ), height( k1.getRight() ) ) + 1;
        k2.height = max( height( k2.getRight() ), k1.height ) + 1;
        return k2;
    }


    private Node doubleWithLeftChild(Node k3)
    {
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild( k3 );
    }



    private Node doubleWithRightChild(Node k1)
    {
        k1.setRight(rotateWithLeftChild(k1.getRight()));
        return rotateWithRightChild( k1 );
    }




    public boolean search(Words val)
    {
        return search(root, val);
    }

    private boolean search(Node r, Words val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            if (r.getData().compareTo(val) < 0)
                r = r.getLeft();
            else if (r.getData().compareTo(val) > 0)
                r = r.getRight();
            else
            {
                found = true;
                System.out.println(r.getData().getWord()+": "+r.getData().getMeaning() );
                break;
            }
            found = search(r, val);
        }
        return found;
    }


    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.println(r.getData().getWord() +" "+r.getData().getMeaning());
            inorder(r.getRight());
        }
    }



    public void preorder()
    {
        preorder(root);
    }
    private void preorder(Node r)
    {
        if (r != null)
        {
            System.out.println(r.getData().getWord() +" "+r.getData().getMeaning());
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }



    public void postorder()
    {
        postorder(root);
    }
    private void postorder(Node r)
    {
        if (r != null)
        {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.println(r.getData().getWord() +" "+r.getData().getMeaning());
        }
    }
}
