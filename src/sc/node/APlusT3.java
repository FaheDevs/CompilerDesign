/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class APlusT3 extends PT3
{
    private PT3 _t3_;
    private TPlus _plus_;
    private PT4 _t4_;

    public APlusT3()
    {
        // Constructor
    }

    public APlusT3(
        @SuppressWarnings("hiding") PT3 _t3_,
        @SuppressWarnings("hiding") TPlus _plus_,
        @SuppressWarnings("hiding") PT4 _t4_)
    {
        // Constructor
        setT3(_t3_);

        setPlus(_plus_);

        setT4(_t4_);

    }

    @Override
    public Object clone()
    {
        return new APlusT3(
            cloneNode(this._t3_),
            cloneNode(this._plus_),
            cloneNode(this._t4_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPlusT3(this);
    }

    public PT3 getT3()
    {
        return this._t3_;
    }

    public void setT3(PT3 node)
    {
        if(this._t3_ != null)
        {
            this._t3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._t3_ = node;
    }

    public TPlus getPlus()
    {
        return this._plus_;
    }

    public void setPlus(TPlus node)
    {
        if(this._plus_ != null)
        {
            this._plus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._plus_ = node;
    }

    public PT4 getT4()
    {
        return this._t4_;
    }

    public void setT4(PT4 node)
    {
        if(this._t4_ != null)
        {
            this._t4_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._t4_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._t3_)
            + toString(this._plus_)
            + toString(this._t4_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._t3_ == child)
        {
            this._t3_ = null;
            return;
        }

        if(this._plus_ == child)
        {
            this._plus_ = null;
            return;
        }

        if(this._t4_ == child)
        {
            this._t4_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._t3_ == oldChild)
        {
            setT3((PT3) newChild);
            return;
        }

        if(this._plus_ == oldChild)
        {
            setPlus((TPlus) newChild);
            return;
        }

        if(this._t4_ == oldChild)
        {
            setT4((PT4) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
