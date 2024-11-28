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

            <label htmlFor="companyId">Company ID: </label>
            <input id="companyId" type="text" />

            <label htmlFor="address">Address: </label>
            <input id="address" type="text" />

            <label htmlFor="numOfEmployees">Number of employees: </label>
            <input id="numOfEmployeess" type="text" />

            <label htmlFor="industry">Industry: </label>
            <input id="industry" type="text" />

            <button type="submit">Submit</button>
        </form>
    )
}