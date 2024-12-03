
export default function FormSubmit({children}) {
    return (
        <div className="pt-2">
            <button type="submit" className="btn btn-primary">
                {children}
            </button>
        </div>
    )
}