import {FormProvider, useForm} from "react-hook-form";
import Text from "../../Form/Text";
import FormSubmit from "../../Form/Submit";
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
                <Text name="category" label="Category" />
                <Text name="name" label="Tech name" />
                <FormSubmit>Save</FormSubmit>
            </form>

        </FormProvider>
    );
}