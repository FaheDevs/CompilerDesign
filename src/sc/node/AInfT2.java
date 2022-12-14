/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AInfT2 extends PT2
{
    private PT2 _t2_;
    private TInferieur _inferieur_;
    private PT3 _t3_;

    public AInfT2()
    {
        // Constructor
    }

    public AInfT2(
        @SuppressWarnings("hiding") PT2 _t2_,
        @SuppressWarnings("hiding") TInferieur _inferieur_,
        @SuppressWarnings("hiding") PT3 _t3_)
    {
        // Constructor
        setT2(_t2_);

        setInferieur(_inferieur_);

        setT3(_t3_);

    }

    @Override
    public Object clone()
    {
        return new AInfT2(
            cloneNode(this._t2_),
            cloneNode(this._inferieur_),
            cloneNode(this._t3_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInfT2(this);
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

    public TInferieur getInferieur()
    {
        return this._inferieur_;
    }

    public void setInferieur(TInferieur node)
    {
        if(this._inferieur_ != null)
        {
            this._inferieur_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._inferieur_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._t2_)
            + toString(this._inferieur_)
            + toString(this._t3_);
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

        if(this._inferieur_ == child)
        {
            this._inferieur_ = null;
            return;
        }

        if(this._t3_ == child)
        {
            this._t3_ = null;
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

        if(this._inferieur_ == oldChild)
        {
            setInferieur((TInferieur) newChild);
            return;
        }

        if(this._t3_ == oldChild)
        {
            setT3((PT3) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
