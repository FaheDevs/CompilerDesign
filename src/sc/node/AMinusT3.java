/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AMinusT3 extends PT3
{
    private PT3 _t3_;
    private TMinus _minus_;
    private PT4 _t4_;

    public AMinusT3()
    {
        // Constructor
    }

    public AMinusT3(
        @SuppressWarnings("hiding") PT3 _t3_,
        @SuppressWarnings("hiding") TMinus _minus_,
        @SuppressWarnings("hiding") PT4 _t4_)
    {
        // Constructor
        setT3(_t3_);

        setMinus(_minus_);

        setT4(_t4_);

    }

    @Override
    public Object clone()
    {
        return new AMinusT3(
            cloneNode(this._t3_),
            cloneNode(this._minus_),
            cloneNode(this._t4_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMinusT3(this);
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

    public TMinus getMinus()
    {
        return this._minus_;
    }

    public void setMinus(TMinus node)
    {
        if(this._minus_ != null)
        {
            this._minus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minus_ = node;
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
            + toString(this._minus_)
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

        if(this._minus_ == child)
        {
            this._minus_ = null;
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

        if(this._minus_ == oldChild)
        {
            setMinus((TMinus) newChild);
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