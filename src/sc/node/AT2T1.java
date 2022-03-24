/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AT2T1 extends PT1
{
    private PT2 _t2_;

    public AT2T1()
    {
        // Constructor
    }

    public AT2T1(
        @SuppressWarnings("hiding") PT2 _t2_)
    {
        // Constructor
        setT2(_t2_);

    }

    @Override
    public Object clone()
    {
        return new AT2T1(
            cloneNode(this._t2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAT2T1(this);
    }

    public PT2 getT2()
    {
        return this._t2_;
    }

    public void setT2(PT2 node)
    {
        if(this._t2_ != null)
        {
            this._t2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._t2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._t2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._t2_ == child)
        {
            this._t2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._t2_ == oldChild)
        {
            setT2((PT2) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}