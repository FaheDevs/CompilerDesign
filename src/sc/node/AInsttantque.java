/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AInsttantque extends PInsttantque
{
    private TTantque _tantque_;
    private PExp _exp_;
    private TFaire _faire_;
    private PInstbloc _instbloc_;

    public AInsttantque()
    {
        // Constructor
    }

    public AInsttantque(
        @SuppressWarnings("hiding") TTantque _tantque_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TFaire _faire_,
        @SuppressWarnings("hiding") PInstbloc _instbloc_)
    {
        // Constructor
        setTantque(_tantque_);

        setExp(_exp_);

        setFaire(_faire_);

        setInstbloc(_instbloc_);

    }

    @Override
    public Object clone()
    {
        return new AInsttantque(
            cloneNode(this._tantque_),
            cloneNode(this._exp_),
            cloneNode(this._faire_),
            cloneNode(this._instbloc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInsttantque(this);
    }

    public TTantque getTantque()
    {
        return this._tantque_;
    }

    public void setTantque(TTantque node)
    {
        if(this._tantque_ != null)
        {
            this._tantque_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tantque_ = node;
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

    public TFaire getFaire()
    {
        return this._faire_;
    }

    public void setFaire(TFaire node)
    {
        if(this._faire_ != null)
        {
            this._faire_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._faire_ = node;
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
            + toString(this._tantque_)
            + toString(this._exp_)
            + toString(this._faire_)
            + toString(this._instbloc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tantque_ == child)
        {
            this._tantque_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._faire_ == child)
        {
            this._faire_ = null;
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
        if(this._tantque_ == oldChild)
        {
            setTantque((TTantque) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._faire_ == oldChild)
        {
            setFaire((TFaire) newChild);
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
