/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AInstecritureInst extends PInst
{
    private PInstecriture _instecriture_;

    public AInstecritureInst()
    {
        // Constructor
    }

    public AInstecritureInst(
        @SuppressWarnings("hiding") PInstecriture _instecriture_)
    {
        // Constructor
        setInstecriture(_instecriture_);

    }

    @Override
    public Object clone()
    {
        return new AInstecritureInst(
            cloneNode(this._instecriture_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInstecritureInst(this);
    }

    public PInstecriture getInstecriture()
    {
        return this._instecriture_;
    }

    public void setInstecriture(PInstecriture node)
    {
        if(this._instecriture_ != null)
        {
            this._instecriture_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._instecriture_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._instecriture_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._instecriture_ == child)
        {
            this._instecriture_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._instecriture_ == oldChild)
        {
            setInstecriture((PInstecriture) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
