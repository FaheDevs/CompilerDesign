/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ADiviseT4 extends PT4
{
    private PT4 _t4_;
    private TDivise _divise_;
    private PT5 _t5_;

    public ADiviseT4()
    {
        // Constructor
    }

    public ADiviseT4(
        @SuppressWarnings("hiding") PT4 _t4_,
        @SuppressWarnings("hiding") TDivise _divise_,
        @SuppressWarnings("hiding") PT5 _t5_)
    {
        // Constructor
        setT4(_t4_);

        setDivise(_divise_);

        setT5(_t5_);

    }

    @Override
    public Object clone()
    {
        return new ADiviseT4(
            cloneNode(this._t4_),
            cloneNode(this._divise_),
            cloneNode(this._t5_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADiviseT4(this);
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

    public TDivise getDivise()
    {
        return this._divise_;
    }

    public void setDivise(TDivise node)
    {
        if(this._divise_ != null)
        {
            this._divise_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._divise_ = node;
    }

    public PT5 getT5()
    {
        return this._t5_;
    }

    public void setT5(PT5 node)
    {
        if(this._t5_ != null)
        {
            this._t5_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._t5_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._t4_)
            + toString(this._divise_)
            + toString(this._t5_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._t4_ == child)
        {
            this._t4_ = null;
            return;
        }

        if(this._divise_ == child)
        {
            this._divise_ = null;
            return;
        }

        if(this._t5_ == child)
        {
            this._t5_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._t4_ == oldChild)
        {
            setT4((PT4) newChild);
            return;
        }

        if(this._divise_ == oldChild)
        {
            setDivise((TDivise) newChild);
            return;
        }

        if(this._t5_ == oldChild)
        {
            setT5((PT5) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
