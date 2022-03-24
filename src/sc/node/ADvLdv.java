/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ADvLdv extends PLdv
{
    private PDv _dv_;

    public ADvLdv()
    {
        // Constructor
    }

    public ADvLdv(
        @SuppressWarnings("hiding") PDv _dv_)
    {
        // Constructor
        setDv(_dv_);

    }

    @Override
    public Object clone()
    {
        return new ADvLdv(
            cloneNode(this._dv_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADvLdv(this);
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
            + toString(this._dv_);
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

        throw new RuntimeException("Not a child.");
    }
}