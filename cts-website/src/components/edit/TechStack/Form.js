import {FormProvider, useForm} from "react-hook-form";
import FormText from "../../form/FormText";
import FormSubmit from "../../form/Submit";
import axios from "axios";


export default function TechStackForm({onSave}) {

    const formMethods = useForm({
        defaultValues: {
            name: '',
            category: '',
        }

    });

    const {handleSubmit} = formMethods;


    const onSubmit = async (data) => {
        const result = await axios('http://localhost:8080/api/v1/techStacks', {
            ...data,
        })
        onSave(data);
    }


    return (
        <FormProvider {...formMethods}>
            <form onSubmit={handleSubmit(onSubmit)}>
                <FormText name="category" label="Category" />
                <FormText name="name" label="Tech name" />
                <FormSubmit>Save</FormSubmit>
            </form>

        </FormProvider>
    );
}