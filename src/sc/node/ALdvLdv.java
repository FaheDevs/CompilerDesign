/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ALdvLdv extends PLdv
{
    private PDv _dv_;
    private PLdvsuite _ldvsuite_;

    public ALdvLdv()
    {
        // Constructor
    }

    public ALdvLdv(
        @SuppressWarnings("hiding") PDv _dv_,
        @SuppressWarnings("hiding") PLdvsuite _ldvsuite_)
    {
        // Constructor
        setDv(_dv_);

        setLdvsuite(_ldvsuite_);

    }

    @Override
    public Object clone()
    {
        return new ALdvLdv(
            cloneNode(this._dv_),
            cloneNode(this._ldvsuite_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALdvLdv(this);
    }

    public PDv getDv()
    {
        return this._dv_;
    }

    public void setDv(PDv node)
    {
        if(this._dv_ != null)
        {
            this._dv_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dv_ = node;
    }

    public PLdvsuite getLdvsuite()
    {
        return this._ldvsuite_;
    }

    public void setLdvsuite(PLdvsuite node)
    {
        if(this._ldvsuite_ != null)
        {
            this._ldvsuite_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ldvsuite_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._dv_)
            + toString(this._ldvsuite_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._dv_ == child)
        {
            this._dv_ = null;
            return;
        }

        if(this._ldvsuite_ == child)
        {
            this._ldvsuite_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._dv_ == oldChild)
        {
            setDv((PDv) newChild);
            return;
        }

        if(this._ldvsuite_ == oldChild)
        {
            setLdvsuite((PLdvsuite) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
