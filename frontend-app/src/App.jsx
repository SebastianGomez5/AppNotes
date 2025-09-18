import { useState, useEffect } from 'react'
import { getNotes, createNote, updateNote, deleteNote } from "./services/noteService";
import './App.css'

function App() {
  const [notes, setNotes] = useState([]);
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [editingId, setEditingId] = useState(null);

   // Cargar notas al inicio
  useEffect(() => {
    fetchNotes();
  }, []);

  const fetchNotes = async () => {
    try {
      const response = await getNotes();
      console.log("Respuesta backend:", response.data);
      setNotes(response.data);
    } catch (error) {
      console.error("Error al cargar notas", error);
    }
  };

  const handleSave = async () => {
    try {
      if (editingId) {
        await updateNote(editingId, { titulo: title, contenido: content });
        setEditingId(null);
      } else {
        await createNote({ titulo: title, contenido: content });
      }
      setTitle("");
      setContent("");
      fetchNotes();
    } catch (error) {
      console.error("Error al guardar nota", error);
    }
  };

  const handleEdit = (note) => {
    setEditingId(note.id);
    setTitle(note.titulo);
    setContent(note.contenido);
  };

  const handleDelete = async (id) => {
    try {
      await deleteNote(id);
      fetchNotes();
    } catch (error) {
      console.error("Error al eliminar nota", error);
    }
  };
  console.log("Notas cargadas:", notes);


  return (
    <div className="app-container">
      <header>
        <h1>📝 AppNotes</h1>
        <p>Create and manage your notes easily</p>
      </header>

      <div className="form">
        <input
          type="text"
          placeholder="Note title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />

        <textarea
          placeholder="Note content..."
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />

        <button onClick={handleSave}>
          {editingId ? "Update Note" : "Save Note"}
        </button>
      </div>

      <div className="notes">
        {notes.map((note) => (
          <div className="note-card" key={note.id}>
            <h2>{note.titulo}</h2>
            <p>{note.contenido}</p>
            <div className="note-actions">
              <button onClick={() => handleEdit(note)} className="edit">✏️ Edit</button>
              <button onClick={() => handleDelete(note.id)} className="delete">🗑️ Delete</button>
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}

export default App
