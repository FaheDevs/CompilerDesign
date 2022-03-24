/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AInstblocInst extends PInst
{
    private PInstbloc _instbloc_;

    public AInstblocInst()
    {
        // Constructor
    }

    public AInstblocInst(
        @SuppressWarnings("hiding") PInstbloc _instbloc_)
    {
        // Constructor
        setInstbloc(_instbloc_);

    }

    @Override
    public Object clone()
    {
        return new AInstblocInst(
            cloneNode(this._instbloc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInstblocInst(this);
    }

    public PInstbloc getInstbloc()
    {
        return this._instbloc_;
    }

    public void setInstbloc(PInstbloc node)
    {
        if(this._instbloc_ != null)
        {
            this._instbloc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._instbloc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._instbloc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._instbloc_ == child)
        {
            this._instbloc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._instbloc_ == oldChild)
        {
            setInstbloc((PInstbloc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}