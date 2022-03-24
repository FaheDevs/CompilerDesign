/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ADfSansvariablesDf extends PDf
{
    private TIdentif _identif_;
    private PLparam _lparam_;
    private PInstbloc _instbloc_;

    public ADfSansvariablesDf()
    {
        // Constructor
    }

    public ADfSansvariablesDf(
        @SuppressWarnings("hiding") TIdentif _identif_,
        @SuppressWarnings("hiding") PLparam _lparam_,
        @SuppressWarnings("hiding") PInstbloc _instbloc_)
    {
        // Constructor
        setIdentif(_identif_);

        setLparam(_lparam_);

        setInstbloc(_instbloc_);

    }

    @Override
    public Object clone()
    {
        return new ADfSansvariablesDf(
            cloneNode(this._identif_),
            cloneNode(this._lparam_),
            cloneNode(this._instbloc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADfSansvariablesDf(this);
    }

    public TIdentif getIdentif()
    {
        return this._identif_;
    }

    public void setIdentif(TIdentif node)
    {
        if(this._identif_ != null)
        {
            this._identif_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identif_ = node;
    }

    public PLparam getLparam()
    {
        return this._lparam_;
    }

    public void setLparam(PLparam node)
    {
        if(this._lparam_ != null)
        {
            this._lparam_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lparam_ = node;
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
            + toString(this._identif_)
            + toString(this._lparam_)
            + toString(this._instbloc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identif_ == child)
        {
            this._identif_ = null;
            return;
        }

        if(this._lparam_ == child)
        {
            this._lparam_ = null;
            return;
        }

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
        if(this._identif_ == oldChild)
        {
            setIdentif((TIdentif) newChild);
            return;
        }

        if(this._lparam_ == oldChild)
        {
            setLparam((PLparam) newChild);
            return;
        }

        if(this._instbloc_ == oldChild)
        {
            setInstbloc((PInstbloc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
