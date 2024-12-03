import TechStackForm from "./Form";

export default function TechStackPage() {

    const saveHandler = (val) => {
        console.log('Saved', val);
    }

    return (
        <TechStackForm onSave={saveHandler} />
    );
}