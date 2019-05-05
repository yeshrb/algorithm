package stack;

/**
 * The type Stack.
 *
 * @param <E> the type parameter
 */
public interface Stack<E> {

    /**
     * Push.
     *
     * @param e the e
     */
    public void push(E e) ;

    /**
     * Pop e.
     *
     * @return the e
     */
    public E pop();

    /**
     * Peek e.
     *
     * @return the e
     */
    public E peek() ;

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() ;

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() ;

}
