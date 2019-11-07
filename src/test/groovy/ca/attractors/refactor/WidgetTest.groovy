package ca.attractors.refactor

import org.junit.Test

import static org.junit.Assert.*;

class WidgetTest {
    @Test
    void testPrintString() {
        Widget widget =  new Widget("123456")
        widget.map =  [a : "Alpha", b: "Beta", c: "This is a test".getBytes() ]
        widget.things.add(new Pencil())
        widget.things.add(new Pen())
        println(widget.toString())      //Wth is this doing here - don't you trust your test???
        assert widget.toString() == getExpectedToString()
    }

    private String getExpectedToString() {
        '''class ca.attractors.refactor.Widget(123-4-56)
\ta: Alpha
\tb: Beta
\tc: (Binary content)
class ca.attractors.refactor.Pencil is heavy
class ca.attractors.refactor.Pen is light
And the total weight is 950 grams'''
    }
}
