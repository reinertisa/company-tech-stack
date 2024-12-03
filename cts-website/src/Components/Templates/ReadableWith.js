import clsx from "clsx";

export default function ReadableWithTemplate({title, className, children}) {

    return (
        <div className="page-wrap">
            <main className={clsx('container', 'readable-width', className)}>
                <header>
                    <h1 className="pageTitle">
                        {title}
                    </h1>
                </header>
                <div>
                    {children}
                </div>
            </main>
        </div>
    );
}