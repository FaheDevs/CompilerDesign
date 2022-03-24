/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AOuExp extends PExp
{
    private PExp _exp_;
    private TOu _ou_;
    private PT1 _t1_;

    public AOuExp()
    {
        // Constructor
    }

    public AOuExp(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TOu _ou_,
        @SuppressWarnings("hiding") PT1 _t1_)
    {
        // Constructor
        setExp(_exp_);

        setOu(_ou_);

        setT1(_t1_);

    }

    @Override
    public Object clone()
    {
        return new AOuExp(
            cloneNode(this._exp_),
            cloneNode(this._ou_),
            cloneNode(this._t1_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOuExp(this);
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public TOu getOu()
    {
        return this._ou_;
    }

    public void setOu(TOu node)
    {
        if(this._ou_ != null)
        {
            this._ou_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ou_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._ou_)
            + toString(this._t1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._ou_ == child)
        {
            this._ou_ = null;
            return;
        }

        if(this._t1_ == child)
        {
            this._t1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._ou_ == oldChild)
        {
            setOu((TOu) newChild);
            return;
        }

        if(this._t1_ == oldChild)
        {
            setT1((PT1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}