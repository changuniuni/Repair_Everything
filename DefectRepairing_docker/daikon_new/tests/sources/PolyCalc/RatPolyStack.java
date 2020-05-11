package PolyCalc;

/** simple cons cell record type. */
class Cons {

    // FSK would make this an inner class of RatPolyStack, but I'm
    // trying to keep learning curve low...

    RatPoly head;
    Cons tail;
    Cons(RatPoly h, Cons t) { head = h; tail = t; }
}

/** RatPolyStack is a mutable finite sequence of RatPoly objects.

    Each RatPolyStack can be described by [p1, p2, ... ], where [] is
    an empty stack, [p1] is a one element stack containing the Poly
    'p1', and so on.  RatPolyStacks can also be described
    constructively, with the append operation, ':'. such that [p1]:S
    is the result of putting p1 at the front of the RatPolyStack S.

    A finite sequence Q has an associated size, notated in these specs
    as the function size-of(Q).  Thus "size-of([]) = 0",
    "size-of([p1]) = 1", "size-of([p1, p1]) = 2", and so on.

 */
public class RatPolyStack {

    private Cons polys; // head of list
    private int size;

    // Definitions:
    // For a Cons c, let Seq(c) be [] if c == null,
    //                             [c.head]:Seq(c.tail) otherwise
    //                   Count(c) be 0 if c == null,
    //                               1 + Count(c.tail) otherwise
    //

    // (( These are helper functions that will make it easier for us
    // to write the remainder of the specifications.  They are
    // seperated out because the nature of this representation lends
    // itself to analysis by recursive functions.  ))

    // Abstraction Function:
    // A RatPolyStack s is Seq(s.polys)

    // (( This explains how we can understand what a Stack is from its
    // 'polys' field.  (Though in truth, the real understanding comes
    // from grokking the List helper function).  ))

    // RepInvariant:
    // s.size == Count(s.polys)

    // (( This defines how the 'size' field relates to the 'polys'
    // field.  Notice that s.polys != null is *not* a given Invariant;
    // this class, unlike the RatPoly class, allows for one of its
    // fields to reference null, and thus your method implementations
    // should not assume that the 'polys' field will be non-null on
    // entry to the method, unless some other aspect of the method
    // will enforce this condition. ))

    // FSK: META-note: some students might ask why we had to define
    // Count(c) when we already have the "size-of(Q)" function given.
    // I was going to make an argument about being allowed to apply
    // the abstraction function, etc, but I now think it might
    // actually be legal to say size-of(Seq(s.polys)), because
    // no-where in there do we apply the AF to a RatPolyStack...

    /** @effects: Constructs a new RatPolyStack, [].
     */
    public RatPolyStack() {
	// IMPL IS STAFF ONLY
	polys = null; size = 0;
    }

    /** Pushes a RatPoly onto the top of this.
	@modifies: this
	@effects: this_post = [p]:this
     */
    public void push(RatPoly p) {
	// IMPL IS STAFF ONLY
	polys = new Cons(p, polys); size++;
    }

    /** Returns the top RatPoly.
	@requires: size-of(this) > 0
	@modifies: this
	@effects: If this = [p]:S
	          then this_post = S && returns p
    */
    public RatPoly pop()  {
	// IMPL IS STAFF ONLY
	if (size <= 0)
	    throw new RuntimeException("!pop on size"+size);

	RatPoly p = polys.head;
	polys = polys.tail;
	size--;
	return p;
    }

    /** Duplicates the top RatPoly on this.
	@requires: size-of(this) > 0
	@modifies: this
	@effects: If this = [p]:S
	          then this_post = [p, p]:S
    */
    public void dup()  {
	// IMPL IS STAFF ONLY
	if (size <= 0)
	    throw new RuntimeException("!dup on size"+size);

	polys = new Cons(polys.head, polys);
	size++;
    }

    /** Swaps the top two elements of this.
	@requires: size-of(this) >= 2
	@modifies: this
	@effects: If this = [p1, p2]:S
	          then this_post = [p2, p1]:S
    */
    public void swap() {
	// IMPL IS STAFF ONLY
	if (size <= 1)
	    throw new RuntimeException("!swap on size"+size);

	Cons c1 = polys;
	Cons c2 = polys.tail;
	c1.tail = c2.tail;
	c2.tail = c1;
	polys = c2;
    }

    /** Clears the stack.
	@modifies: this
	@effects: this_post = []
    */
    public void clear() {
	// IMPL IS STAFF ONLY
        polys = null;
        size = 0;
    }

    /** Returns the RatPoly that is 'index' elements from the top of
	the stack.
	@requires: index < size-of(this)
	@effects: If this = S:[p]:T where size-of(S) = index, then
	          returns p.
    */
    public RatPoly get(int index) {
	// IMPL IS STAFF ONLY
	if (size <= index)
	    throw new RuntimeException("!get("+index+" on size"+size);

	return getCons(index).head;
    }

    /** Adds the top two elements of this, placing the result on top
	of the stack. 
        @requires: size-of(this) >= 2
	@modifies: this
	@effects:  If this = [p1, p2]:S
                   then this_post = [p3]:S
                   where p3 = p1 + p2
    */
    public void add()
    {
	RatPoly r1 = pop();
	RatPoly r2 = pop();
        RatPoly r3 = r2.add(r1);
        push(r3);
    }
    
    /** Subtracts the top poly from the next from top poly, placing
	the result on top of the stack.
        @requires: size-of(this) >= 2
	@modifies: this
	@effects:  If this = [p1, p2]:S
                   then this_post = [p3]:S
                   where p3 = p2 - p1
    */
    public void sub()
    {
	RatPoly r1 = pop();
        RatPoly r2 = pop();
        RatPoly r3 = r2.sub(r1);
        push(r3);
    }

    /** Multiplies top two elements of this, placing the result on
	top of the stack. 
	@requires: size-of(this) >= 2
	@modifies: this
	@effects:  If this = [p1, p2]:S
                   then this_post = [p3]:S
                   where p3 = p1 * p2
    */
    public void mul()
    {
	RatPoly r1 = pop();
        RatPoly r2 = pop();
        RatPoly r3 = r2.mul(r1);
        push(r3);
     }

    /** Divides the next from top poly by the top poly, placing the
	result on top of the stack.
	@requires: size-of(this) >= 2
	@modifies: this
	@effects:  If this = [p1, p2]:S
                   then this_post = [p3]:S
                   where p3 = p2 / p1
    */
    public void div()
    {
	RatPoly r1 = pop();
        RatPoly r2 = pop();
        RatPoly r3 = r2.div(r1);
        push(r3);
    }


    /** @return size-of(this)
     */
    public int size() {
	// IMPL IS STAFF ONLY
	return size;
    }

    // METHOD IS STAFF ONLY
    // helper method
    private Cons getCons(int index) {
	final int index_orig = index;
	Cons curr = polys;
	while(index > 0) {
	    if (curr == null) {
		throw new RuntimeException
		    ("getCons ran out of elems, "+
		     "index:"+index+" index_orig:"+index_orig);
	    }

	    curr = curr.tail;
	    index--;

	    if (curr == null) {
		throw new RuntimeException
		    ("getCons ran out of elems, "+
		     "index:"+index+" index_orig:"+index_orig);
	    }
	}
	return curr;
    }
}
