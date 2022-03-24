/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ASuiteDvLdvsuite extends PLdvsuite
{
    private TVirgule _virgule_;
    private PDv _dv_;

    public ASuiteDvLdvsuite()
    {
        // Constructor
    }

    public ASuiteDvLdvsuite(
        @SuppressWarnings("hiding") TVirgule _virgule_,
        @SuppressWarnings("hiding") PDv _dv_)
    {
        // Constructor
        setVirgule(_virgule_);

        setDv(_dv_);

    }

    @Override
    public Object clone()
    {
        return new ASuiteDvLdvsuite(
            cloneNode(this._virgule_),
            cloneNode(this._dv_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASuiteDvLdvsuite(this);
    }

    public TVirgule getVirgule()
    {
        return this._virgule_;
    }

    public void setVirgule(TVirgule node)
    {
        if(this._virgule_ != null)
        {
            this._virgule_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._virgule_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._virgule_)
            + toString(this._dv_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._virgule_ == child)
        {
            this._virgule_ = null;
            return;
        }

        if(this._dv_ == child)
        {
            this._dv_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._virgule_ == oldChild)
        {
            setVirgule((TVirgule) newChild);
            return;
        }

        if(this._dv_ == oldChild)
        {
            setDv((PDv) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
