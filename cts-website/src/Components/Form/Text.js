import {useFormContext} from "react-hook-form";
import clsx from "clsx";

export default function FormText({name, label, defaultValue, className, style, ...inputAttribs}) {
    const {register, formState: {errors}} = useFormContext();

    return (
        <div className={clsx(className)} style={style}>
            <label htmlFor={name}>
                {label}{' '}
                <input
                    type="text"
                    {...register(name)}
                    className={clsx('form-control', className)}
                    defaultValue={defaultValue}
                    {...inputAttribs}
                />
            </label>
        </div>
    )
}