import {useForm} from 'react-hook-form';

export default function CompanyForm() {
    const {register, handleSubmit} = useForm({
        defaultValues: {
            name: '',
        }
    });

    const onSubmit = (data) => {
        console.log('Data submitted successfully');
        console.log(data);
    }

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <label htmlFor="name">Company name: </label>
            <input
                id="name"
                type="text"
                {...register('name', {
                    required: {
                        value: true,
                        message: 'This field is required.'
                    }
                })}
            />
            <button type="submit">Submit</button>
        </form>
    )
}