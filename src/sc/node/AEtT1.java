/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AEtT1 extends PT1
{
    private PT1 _t1_;
    private TEt _et_;
    private PT2 _t2_;

    public AEtT1()
    {
        // Constructor
    }

    public AEtT1(
        @SuppressWarnings("hiding") PT1 _t1_,
        @SuppressWarnings("hiding") TEt _et_,
        @SuppressWarnings("hiding") PT2 _t2_)
    {
        // Constructor
        setT1(_t1_);

        setEt(_et_);

        setT2(_t2_);

    }

    @Override
    public Object clone()
    {
        return new AEtT1(
            cloneNode(this._t1_),
            cloneNode(this._et_),
            cloneNode(this._t2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEtT1(this);
    }

    public PT1 getT1()
    {
        return this._t1_;
    }

    public void setT1(PT1 node)
    {
        if(this._t1_ != null)
        {
            this._t1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._t1_ = node;
    }

    public TEt getEt()
    {
        return this._et_;
    }

    public void setEt(TEt node)
    {
        if(this._et_ != null)
        {
            this._et_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._et_ = node;
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
            + toString(this._t1_)
            + toString(this._et_)
            + toString(this._t2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._t1_ == child)
        {
            this._t1_ = null;
            return;
        }

        if(this._et_ == child)
        {
            this._et_ = null;
            return;
        }

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
        if(this._t1_ == oldChild)
        {
            setT1((PT1) newChild);
            return;
        }

        if(this._et_ == oldChild)
        {
            setEt((TEt) newChild);
            return;
        }

        if(this._t2_ == oldChild)
        {
            setT2((PT2) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
